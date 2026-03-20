package com.katebeavis.tubespotter.domain.model

data class Station(
    val id: Int,
    val name: String,
    val zone: String,
    val isVisited: Boolean,
    val visitedAt: Long?,
    val photoUri: String? = null,
)