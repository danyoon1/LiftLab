package com.a27.liftlab.lift.data.dto

data class WorkoutDto(
    val _id: String,
    val name: String,
    val difficulty: String,
    val exercises: List<ExerciseDto>
)