package com.katebeavis.tubespotter.domain.usecase

import com.katebeavis.tubespotter.domain.model.Line
import com.katebeavis.tubespotter.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllLinesUseCase @Inject constructor(
    private val repository: StationRepository,
) {
    operator fun invoke(): Flow<List<Line>> = repository.getAllLines()
}