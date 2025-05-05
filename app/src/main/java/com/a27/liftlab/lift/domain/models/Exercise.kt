package com.a27.liftlab.lift.domain.models

data class Exercise(
    val id: String,
    val name: String,
    val reps: Int,
    val sets: Int
)