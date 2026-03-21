package com.katebeavis.tubespotter.domain.model

data class Achievement(
    val id: Int,
    val lineId: Int?,
    val lineName: String?,
    val unlockedAt: Long?,
) {
    val isUnlocked: Boolean get() = unlockedAt != null
}