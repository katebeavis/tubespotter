package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GetAllStationsUseCaseTest {

    private val repository = mockk<StationRepository>()
    private val useCase = GetAllStationsUseCase(repository)

    @Test
    fun `returns stations from repository`() = runTest {
        val stations = listOf(
            Station(id = 1, name = "Waterloo", zone = "1", isVisited = false, visitedAt = null),
            Station(id = 2, name = "Bank", zone = "1", isVisited = true, visitedAt = 123L),
        )
        every { repository.getAllStations() } returns flowOf(stations)

        val result = useCase().first()

        assertThat(result).isEqualTo(stations)
    }
}