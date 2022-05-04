package com.rogowskibart.zadanior.domain

import java.util.*

data class Task(
    val name: String,
    val priority: Int,
    val deadline: Date,
    val percentage: Int,
    val timeline: Int,
)
