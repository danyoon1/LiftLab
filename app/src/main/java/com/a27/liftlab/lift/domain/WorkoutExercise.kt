package com.a27.liftlab.lift.domain

import androidx.compose.ui.graphics.vector.ImageVector

data class WorkoutExercise(
    val name: String,
    val reps: Int,
    val sets: Int,
    val icon: ImageVector
)