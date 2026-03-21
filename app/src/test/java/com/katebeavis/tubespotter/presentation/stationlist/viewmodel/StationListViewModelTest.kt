package com.katebeavis.tubespotter.presentation.stationlist.viewmodel

import com.katebeavis.tubespotter.domain.model.Line
import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.usecase.GetAllLinesUseCase
import com.katebeavis.tubespotter.domain.usecase.GetAllStationsUseCase
import com.katebeavis.tubespotter.domain.usecase.GetStationsByLineUseCase
import com.katebeavis.tubespotter.domain.usecase.ToggleStationVisitedUseCase
import com.google.common.truth.Truth.assertThat
import com.katebeavis.tubespotter.data.local.photo.PhotoStorage
import com.katebeavis.tubespotter.domain.usecase.CheckLineCompletionUseCase
import com.katebeavis.tubespotter.domain.usecase.DeleteStationPhotoUseCase
import com.katebeavis.tubespotter.domain.usecase.SaveStationPhotoUseCase
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class StationListViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()
    private val getAllStations = mockk<GetAllStationsUseCase>()
    private val getStationsByLine = mockk<GetStationsByLineUseCase>()
    private val getAllLines = mockk<GetAllLinesUseCase>()
    private val toggleStationVisited = mockk<ToggleStationVisitedUseCase>()
    private val saveStationPhoto = mockk<SaveStationPhotoUseCase>()
    private val deleteStationPhoto = mockk<DeleteStationPhotoUseCase>()
    private val photoStorage = mockk<PhotoStorage>()
    private val checkLineCompletion = mockk<CheckLineCompletionUseCase>()

    private val stations = listOf(
        Station(id = 1, name = "Waterloo", zone = "1", isVisited = false, visitedAt = null),
        Station(id = 2, name = "Bank", zone = "1", isVisited = true, visitedAt = 123L),
    )

    private val lines = listOf(
        Line(id = 1, name = "Bakerloo", colour = "#B36305", displayOrder = 1),
        Line(id = 11, name = "Waterloo & City", colour = "#95CDBA", displayOrder = 11),
    )

    private val waterlooAndCityStations = listOf(
        Station(id = 1, name = "Waterloo", zone = "1", isVisited = false, visitedAt = null),
        Station(id = 2, name = "Bank", zone = "1", isVisited = false, visitedAt = null),
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        every { getAllStations() } returns flowOf(stations)
        every { getAllLines() } returns flowOf(lines)
        every { getStationsByLine(any()) } returns flowOf(waterlooAndCityStations)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state loads stations and lines`() = runTest {
        val viewModel = buildViewModel()

        assertThat(viewModel.uiState.value.stations).isEqualTo(stations)
        assertThat(viewModel.uiState.value.lines).isEqualTo(lines)
        assertThat(viewModel.uiState.value.selectedLineId).isNull()
    }

    @Test
    fun `SelectLine action updates selectedLineId and filters stations`() = runTest {
        val viewModel = buildViewModel()

        viewModel.postAction(StationListUiAction.SelectLine(11))

        assertThat(viewModel.uiState.value.selectedLineId).isEqualTo(11)
        assertThat(viewModel.uiState.value.stations).isEqualTo(waterlooAndCityStations)
    }

    @Test
    fun `ClearFilter action resets selectedLineId and shows all stations`() = runTest {
        val viewModel = buildViewModel()
        viewModel.postAction(StationListUiAction.SelectLine(11))

        viewModel.postAction(StationListUiAction.ClearFilter)

        assertThat(viewModel.uiState.value.selectedLineId).isNull()
        assertThat(viewModel.uiState.value.stations).isEqualTo(stations)
    }

    @Test
    fun `ToggleStation action calls use case`() = runTest {
        coJustRun { toggleStationVisited(any()) }
        coJustRun { checkLineCompletion(any()) }
        val viewModel = buildViewModel()

        viewModel.postAction(StationListUiAction.ToggleStation(stations.first()))

        coVerify { toggleStationVisited(stations.first()) }
    }

    private fun buildViewModel() = StationListViewModel(
        getAllStations = getAllStations,
        getStationsByLine = getStationsByLine,
        getAllLines = getAllLines,
        toggleStationVisited = toggleStationVisited,
        saveStationPhoto = saveStationPhoto,
        deleteStationPhoto = deleteStationPhoto,
        photoStorage = photoStorage,
        checkLineCompletion = checkLineCompletion
    )
}