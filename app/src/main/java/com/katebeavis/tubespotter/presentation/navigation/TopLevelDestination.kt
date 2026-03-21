package com.katebeavis.tubespotter.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Train
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val route: Any,
    val icon: ImageVector,
    val label: String,
) {
    STATIONS(
        route = StationListRoute,
        icon = Icons.Default.Train,
        label = "Stations",
    ),
    ACHIEVEMENTS(
        route = AchievementsRoute,
        icon = Icons.Default.EmojiEvents,
        label = "Achievements",
    ),
}