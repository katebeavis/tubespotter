package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Line
import com.katebeavis.tubespotter.domain.repository.StationRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetAllLinesUseCaseTest {

    private val repository = mockk<StationRepository>()
    private val useCase = GetAllLinesUseCase(repository)

    @Test
    fun `returns lines from repository`() = runTest {
        val lines = listOf(
            Line(id = 1, name = "Bakerloo", colour = "#B36305", displayOrder = 1),
            Line(id = 2, name = "Central", colour = "#E32017", displayOrder = 2),
        )
        every { repository.getAllLines() } returns flowOf(lines)

        val result = useCase().first()

        assertThat(result).isEqualTo(lines)
    }
}