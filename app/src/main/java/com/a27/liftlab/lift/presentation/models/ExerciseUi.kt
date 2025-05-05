package com.a27.liftlab.lift.presentation.models

import com.a27.liftlab.lift.domain.models.Exercise
import com.example.liftlab.R

data class ExerciseUi(
    val id: String,
    val name: String,
    val reps: Int,
    val sets: Int,
    val iconRes: Int = R.drawable.dumbbell_simple
)

fun Exercise.toExerciseUi(): ExerciseUi {
    return ExerciseUi(
        id = id,
        name = name,
        reps = reps,
        sets = sets
    )
}