package com.katebeavis.tubespotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.katebeavis.tubespotter.presentation.stationlist.StationListScreen
import com.katebeavis.tubespotter.presentation.common.theme.TubeSpotterTheme
import com.katebeavis.tubespotter.presentation.navigation.TubeSpotterScaffold
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TubeSpotterTheme {
                TubeSpotterScaffold()
            }
        }
    }
}