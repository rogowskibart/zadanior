package com.rogowskibart.zadanior.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rogowskibart.zadanior.model.Task
import java.util.*

@Entity
data class TaskDto(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val priority: Int,
    val deadline: Date,
    val percentage: Int,
    val timeline: Int,
) {
    fun toTaskModel(): Task {
        return Task(
            id, name, priority, deadline, percentage, timeline
        )
    }
}