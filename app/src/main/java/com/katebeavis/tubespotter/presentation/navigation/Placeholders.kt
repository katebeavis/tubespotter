package com.katebeavis.tubespotter.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StationListPlaceholder(onNavigateToDetail: (Int) -> Unit) {
    Text("Station List")
}

@Composable
fun StationDetailPlaceholder(stationId: Int, onBack: () -> Unit) {
    Text("Station Detail: $stationId")
}

@Composable
fun AchievementsPlaceholder() {
    Text("Achievements")
}