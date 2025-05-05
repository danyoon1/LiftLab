package com.a27.liftlab.lift.presentation.home_route.create_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.a27.liftlab.lift.presentation.navigation.Destination
import com.a27.liftlab.lift.presentation.home_route.create_workout.navigateToSelectExercise
import kotlinx.serialization.Serializable


fun NavGraphBuilder.createWorkoutScreen(
    onNavigateToWorkoutEntry: (workoutLength: Int, restPeriod: Int) -> Unit
) {
    composable<Destination.CreateWorkoutDestination> {
        CreateWorkoutScreen(
            onNavigateToWorkoutEntry = onNavigateToWorkoutEntry
        )
    }
}

fun NavController.navigateToCreateWorkout() {
    navigate(Destination.CreateWorkoutDestination)
}
