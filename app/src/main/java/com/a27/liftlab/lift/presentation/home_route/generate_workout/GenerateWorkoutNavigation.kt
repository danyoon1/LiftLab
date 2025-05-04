package com.a27.liftlab.lift.presentation.home_route.generate_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination
import com.a27.liftlab.lift.presentation.navigation.SubRoute
import kotlinx.serialization.Serializable

fun NavGraphBuilder.generateWorkoutScreen(
    onNavigateToWorkoutPlan: () -> Unit
) {
    composable<Destination.GenerateWorkoutDestination> {
        GenerateWorkoutScreen(
            onNavigateToWorkoutPlan = onNavigateToWorkoutPlan
        )
    }
}

fun NavController.navigateToGenerateWorkout() {
    navigate(Destination.GenerateWorkoutDestination)
}