package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ToggleStationVisitedUseCaseTest {

    private val repository = mockk<StationRepository>()
    private val useCase = ToggleStationVisitedUseCase(repository)

    @Test
    fun `marks unvisited station as visited`() = runTest {
        val station = Station(id = 1, name = "Waterloo", zone = "1", isVisited = false, visitedAt = null)
        coJustRun { repository.toggleStationVisited(any()) }

        useCase(station)

        coVerify {
            repository.toggleStationVisited(match { it.isVisited && it.visitedAt != null })
        }
    }

    @Test
    fun `marks visited station as unvisited`() = runTest {
        val station = Station(id = 1, name = "Waterloo", zone = "1", isVisited = true, visitedAt = 123L)
        coJustRun { repository.toggleStationVisited(any()) }

        useCase(station)

        coVerify {
            repository.toggleStationVisited(match { !it.isVisited && it.visitedAt == null })
        }
    }
}