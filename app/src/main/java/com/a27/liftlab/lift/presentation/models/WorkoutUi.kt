package com.a27.liftlab.lift.presentation.models

import com.a27.liftlab.lift.domain.models.Workout

data class WorkoutUi(
    val id: String,
    val name: String,
    val difficulty: String,
    val exercises: List<ExerciseUi>
)

fun Workout.toWorkoutUi(): WorkoutUi {
    return WorkoutUi(
        id = id,
        name = name,
        difficulty = difficulty,
        exercises = exercises.map { it.toExerciseUi() }
    )
}