package com.katebeavis.tubespotter.presentation.stationlist.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.katebeavis.tubespotter.domain.model.Station

@Composable
fun StationItem(
    station: Station,
    onToggle: (Station) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = station.isVisited,
            onCheckedChange = { onToggle(station) },
        )
        Text(
            text = "${station.name} (Zone ${station.zone})",
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}