package com.katebeavis.tubespotter.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object StationListRoute: NavKey

@Serializable
data class StationDetailRoute(val stationId: Int): NavKey

@Serializable
data object AchievementsRoute: NavKey