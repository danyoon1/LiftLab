package com.a27.liftlab.lift.presentation.home_route.create_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.a27.liftlab.lift.presentation.navigation.Destination
import kotlinx.serialization.Serializable

fun NavGraphBuilder.workoutEntryScreen(
    workoutLength: Int,
    restPeriod: Int,
    onSelectEntry: (Int) -> Unit
) {
    composable<Destination.WorkoutEntryDestination> {
        WorkoutEntryScreen(workoutLength = workoutLength, restPeriod = restPeriod, onSelectEntry = onSelectEntry)

    }
}

fun NavController.navigateToWorkoutEntry(workoutLength: Int, restPeriod: Int) {
    navigate(Destination.WorkoutEntryDestination)
}