package com.katebeavis.tubespotter.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.katebeavis.tubespotter.presentation.achievements.AchievementsScreen
import com.katebeavis.tubespotter.presentation.stationdetail.StationDetailScreen
import com.katebeavis.tubespotter.presentation.stationlist.StationListScreen

@Composable
fun TubeSpotterScaffold() {
    val backStack = rememberNavBackStack(StationListRoute)
    val currentDestination = backStack.lastOrNull()

    val isTopLevel = currentDestination != null &&
            TopLevelDestination.entries.any { it.route::class == currentDestination::class }

    Scaffold(
        bottomBar = {
            if (isTopLevel) {
                NavigationBar {
                    TopLevelDestination.entries.forEach { destination ->
                        val selected = destination.route::class == currentDestination::class
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                if (!selected) {
                                    backStack.clear()
                                    backStack.add(destination.route as NavKey)
                                }
                            },
                            icon = { Icon(destination.icon, contentDescription = destination.label) },
                            label = { Text(destination.label) },
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavDisplay(
            modifier = Modifier.padding(paddingValues),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<StationListRoute> {
                    StationListScreen(
                        onNavigateToDetail = { stationId ->
                            backStack.add(StationDetailRoute(stationId))
                        }
                    )
                }
                entry<StationDetailRoute> { key ->
                    StationDetailScreen(onBack = { backStack.removeLastOrNull() },stationId = key.stationId,)
                }
                entry<AchievementsRoute> {
                    AchievementsScreen()
                }
            },
        )
    }
}