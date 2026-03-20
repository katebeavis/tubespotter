package com.katebeavis.tubespotter.presentation.stationlist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.katebeavis.tubespotter.domain.model.Line
import androidx.core.graphics.toColorInt

@Composable
fun LineFilterChips(
    lines: List<Line>,
    selectedLineId: Int?,
    onLineSelected: (Int) -> Unit,
    onClearFilter: () -> Unit,
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            FilterChip(
                selected = selectedLineId == null,
                onClick = onClearFilter,
                label = { Text("All") },
            )
        }
        items(
            items = lines,
            key = { it.id },
        ) { line ->
            val lineColour = Color(line.colour.toColorInt())
            FilterChip(
                selected = selectedLineId == line.id,
                onClick = { onLineSelected(line.id) },
                label = { Text(line.name) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = lineColour,
                    selectedLabelColor = Color.White,
                ),
            )
        }
    }
}