package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.usecase.GetAllStationsUseCase
import com.katebeavis.tubespotter.domain.usecase.ToggleStationVisitedUseCase
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Test

class StationListViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()
    private val getAllStations = mockk<GetAllStationsUseCase>()
    private val toggleStationVisited = mockk<ToggleStationVisitedUseCase>()

    private val stations = listOf(
        Station(id = 1, name = "Waterloo", zone = "1", isVisited = false, visitedAt = null),
        Station(id = 2, name = "Bank", zone = "1", isVisited = true, visitedAt = 123L),
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        every { getAllStations() } returns flowOf(stations)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state loads stations correctly`() = runTest {
        val viewModel = StationListViewModel(getAllStations, toggleStationVisited)

        val state = viewModel.uiState.value

        assertThat(state.stations).isEqualTo(stations)
        assertThat(state.visitedCount).isEqualTo(1)
        assertThat(state.totalCount).isEqualTo(2)
    }

    @Test
    fun `ToggleStation action calls use case`() = runTest {
        coJustRun { toggleStationVisited(any()) }
        val viewModel = StationListViewModel(getAllStations, toggleStationVisited)
        val station = stations.first()

        viewModel.postAction(StationListUiAction.ToggleStation(station))

        coVerify { toggleStationVisited(station) }
    }
}
    