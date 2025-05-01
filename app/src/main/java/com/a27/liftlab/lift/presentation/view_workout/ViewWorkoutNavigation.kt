package com.a27.liftlab.lift.presentation.view_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ViewWorkoutDestination

fun NavGraphBuilder.viewWorkoutScreen() {
    composable<ViewWorkoutDestination> {
        ViewWorkoutScreen()
    }
}

fun NavController.navigateToViewWorkout() {
    navigate(ViewWorkoutDestination)
}