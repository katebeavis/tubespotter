package com.katebeavis.tubespotter.presentation.stationlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.katebeavis.tubespotter.domain.model.Station

@Composable
fun StationItem(
    station: Station,
    onToggle: (Station) -> Unit,
    onTakePhoto: (Int) -> Unit,
    onDeletePhoto: (Int, String) -> Unit,
    modifier: Modifier = Modifier,
    onSelectStation: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSelectStation(station.id) }
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
        if (station.photoUri != null) {
            AsyncImage(
                model = station.photoUri,
                contentDescription = "Photo of ${station.name}",
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 4.dp),
                contentScale = ContentScale.Crop,
            )
            IconButton(onClick = { onDeletePhoto(station.id, station.photoUri) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete photo",
                )
            }
        } else {
            IconButton(onClick = { onTakePhoto(station.id) }) {
                Icon(
                    imageVector = Icons.Default.AddAPhoto,
                    contentDescription = "Take photo",
                )
            }
        }
    }
}