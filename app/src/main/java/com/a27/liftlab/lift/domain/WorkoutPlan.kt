package com.a27.liftlab.lift.domain

data class WorkoutPlan(
    val name: String,
    val difficulty: String,
    val exercises: List<WorkoutExercise>
)