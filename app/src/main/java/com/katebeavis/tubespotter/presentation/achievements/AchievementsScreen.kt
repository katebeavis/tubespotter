package com.katebeavis.tubespotter.presentation.achievements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.katebeavis.tubespotter.domain.model.Achievement
import com.katebeavis.tubespotter.presentation.achievements.viewmodel.AchievementsUiState
import com.katebeavis.tubespotter.presentation.achievements.viewmodel.AchievementsViewModel

@Composable
fun AchievementsScreen(
    viewModel: AchievementsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    AchievementsContent(uiState = uiState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AchievementsContent(
    uiState: AchievementsUiState,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Achievements") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            items(
                items = uiState.achievements,
                key = { it.id },
            ) { achievement ->
                AchievementItem(achievement = achievement)
            }
        }
    }
}

@Composable
private fun AchievementItem(
    achievement: Achievement,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = achievement.lineName ?: "All Stations",
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Icon(
            imageVector = if (achievement.isUnlocked) Icons.Default.EmojiEvents else Icons.Default.Lock,
            contentDescription = if (achievement.isUnlocked) "Unlocked" else "Locked",
        )
    }
}