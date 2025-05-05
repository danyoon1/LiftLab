package com.a27.liftlab.lift.domain.models

data class Workout(
    val id: String,
    val name: String,
    val difficulty: String,
    val exercises: List<Exercise>
)