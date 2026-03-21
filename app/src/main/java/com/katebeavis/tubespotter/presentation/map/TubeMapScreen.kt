package com.katebeavis.tubespotter.presentation.map

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.input.pointer.pointerInput
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.katebeavis.tubespotter.domain.model.StationCoordinate
import com.katebeavis.tubespotter.domain.usecase.MapStation
import com.katebeavis.tubespotter.presentation.map.viewmodel.TubeMapUiAction
import com.katebeavis.tubespotter.presentation.map.viewmodel.TubeMapUiSideEffect
import com.katebeavis.tubespotter.presentation.map.viewmodel.TubeMapUiState
import com.katebeavis.tubespotter.presentation.map.viewmodel.TubeMapViewModel
import com.katebeavis.tubespotter.data.local.seed.LineRoutes

@Composable
fun TubeMapScreen(
    onNavigateToDetail: (Int) -> Unit,
    viewModel: TubeMapViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                is TubeMapUiSideEffect.NavigateToDetail -> onNavigateToDetail(effect.stationId)
            }
        }
    }

    TubeMapContent(
        uiState = uiState,
        onAction = viewModel::postAction,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TubeMapContent(
    uiState: TubeMapUiState,
    onAction: (TubeMapUiAction) -> Unit,
) {
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    val transformableState = rememberTransformableState { zoomChange, panChange, _ ->
        scale = (scale * zoomChange).coerceIn(0.5f, 5f)
        offset += panChange
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Map") })
        }
    ) { paddingValues ->
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .transformable(state = transformableState)
                .pointerInput(uiState.stations, scale, offset) {
                    detectTapGestures { tapOffset ->
                        val pivotX = size.width / 2f
                        val pivotY = size.height / 2f
                        val canvasTapX = (tapOffset.x - offset.x - pivotX) / scale + pivotX
                        val canvasTapY = (tapOffset.y - offset.y - pivotY) / scale + pivotY
                        val canvasTap = Offset(canvasTapX, canvasTapY)

                        val tapped = uiState.stations.firstOrNull { mapStation ->
                            val stationOffset = mapStation.coordinate.toScreenOffset(
                                canvasWidth = size.width.toFloat(),
                                canvasHeight = size.height.toFloat(),
                            )
                            (canvasTap - stationOffset).getDistance() < 24f
                        }
                        tapped?.let { onAction(TubeMapUiAction.StationTapped(it.station.id)) }
                    }
                }
        ) {
            withTransform({
                translate(offset.x, offset.y)
                scale(scale, scale, pivot = Offset(size.width / 2f, size.height / 2f))
            }) {
                drawLines(uiState.stations, size.width, size.height)
                uiState.stations.forEach { mapStation ->
                    val position = mapStation.coordinate.toScreenOffset(
                        canvasWidth = size.width,
                        canvasHeight = size.height,
                    )
                    drawStation(
                        position = position,
                        isVisited = mapStation.station.isVisited,
                    )
                }
            }
        }
    }
}

private fun DrawScope.drawStation(
    position: Offset,
    isVisited: Boolean,
) {
    if (isVisited) {
        drawCircle(color = Color(0xFF1A6BC4), radius = 8f, center = position)
    } else {
        drawCircle(color = Color.LightGray, radius = 8f, center = position)
        drawCircle(color = Color.DarkGray, radius = 8f, center = position, style = Stroke(width = 2f))
    }
}

private fun StationCoordinate.toScreenOffset(
    canvasWidth: Float,
    canvasHeight: Float,
): Offset = Offset(
    x = (x / 1000f) * canvasWidth,
    y = (y / 1000f) * canvasHeight,
)

private fun DrawScope.drawLines(
    stations: List<MapStation>,
    canvasWidth: Float,
    canvasHeight: Float,
) {
    val coordMap = stations.associate { it.station.id to it.coordinate.toScreenOffset(canvasWidth, canvasHeight) }
    val lineColours = mapOf(
        1 to Color(0xFFB36305),  // Bakerloo
        2 to Color(0xFFE32017),  // Central
        3 to Color(0xFFFFD300),  // Circle
        4 to Color(0xFF00782A),  // District
        5 to Color(0xFFF3A9BB),  // Hammersmith & City
        6 to Color(0xFFA0A5A9),  // Jubilee
        7 to Color(0xFF9B0056),  // Metropolitan
        8 to Color(0xFF000000),  // Northern
        9 to Color(0xFF003688),  // Piccadilly
        10 to Color(0xFF0098D4), // Victoria
        11 to Color(0xFF95CDBA), // Waterloo & City
    )

    LineRoutes.segments.forEach { (lineId, segments) ->
        val colour = lineColours[lineId] ?: Color.Gray
        val needsOutline = lineId == 8 // Northern is black — needs white underline to show on dark background
        segments.forEach { segment ->
            segment.zipWithNext { fromId, toId ->
                val from = coordMap[fromId] ?: return@zipWithNext
                val to = coordMap[toId] ?: return@zipWithNext
                if (needsOutline) {
                    drawLine(color = Color.White, start = from, end = to, strokeWidth = 10f)
                }
                drawLine(color = colour, start = from, end = to, strokeWidth = 6f)
            }
        }
    }
}
