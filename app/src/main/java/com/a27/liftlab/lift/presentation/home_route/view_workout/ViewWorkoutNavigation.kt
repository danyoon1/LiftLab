package com.a27.liftlab.lift.presentation.home_route.view_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination
import kotlinx.serialization.Serializable

fun NavGraphBuilder.viewWorkoutScreen(
    username: String,
    onNavigateToWorkoutPlan: (workoutId: String) -> Unit
) {
    composable<Destination.ViewWorkoutDestination> {
        ViewWorkoutScreen(
            username = username,
            onNavigateToWorkoutPlan = onNavigateToWorkoutPlan
        )
    }
}

fun NavController.navigateToViewWorkout() {
    navigate(Destination.ViewWorkoutDestination)
}