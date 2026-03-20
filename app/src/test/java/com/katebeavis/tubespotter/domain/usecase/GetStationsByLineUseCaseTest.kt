package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Station
import com.katebeavis.tubespotter.domain.repository.StationRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetStationsByLineUseCaseTest {

    private val repository = mockk<StationRepository>()
    private val useCase = GetStationsByLineUseCase(repository)

    @Test
    fun `returns stations for given line id`() = runTest {
        val stations = listOf(
            Station(id = 1, name = "Waterloo", zone = "1", isVisited = false, visitedAt = null),
            Station(id = 2, name = "Bank", zone = "1", isVisited = false, visitedAt = null),
        )
        every { repository.getStationsByLineId(11) } returns flowOf(stations)

        val result = useCase(11).first()

        assertThat(result).isEqualTo(stations)
    }
}