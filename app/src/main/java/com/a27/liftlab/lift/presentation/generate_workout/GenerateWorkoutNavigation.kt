package com.a27.liftlab.lift.presentation.generate_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object GenerateWorkoutDestination

fun NavGraphBuilder.generateWorkoutScreen(
    onNavigateToWorkoutPlan: () -> Unit
) {
    composable<GenerateWorkoutDestination> {
        GenerateWorkoutScreen(
            onNavigateToWorkoutPlan = onNavigateToWorkoutPlan
        )
    }
}

fun NavController.navigateToGenerateWorkout() {
    navigate(GenerateWorkoutDestination)
}