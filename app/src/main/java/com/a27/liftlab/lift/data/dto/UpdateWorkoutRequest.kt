package com.a27.liftlab.lift.data.dto

data class UpdateWorkoutRequest(
    val username: String,
    val workout: Int,
    val exerciseArray: List<ExerciseDto>
)