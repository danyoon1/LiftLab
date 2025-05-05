package com.a27.liftlab.lift.data.dto

data class CreateWorkoutRequest(
    val username: String,
    val name: String,
    val difficulty: String,
    val exerciseArray: List<ExerciseDto>
)