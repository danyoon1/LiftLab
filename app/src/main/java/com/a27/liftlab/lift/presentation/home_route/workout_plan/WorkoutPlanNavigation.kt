package com.a27.liftlab.lift.presentation.home_route.workout_plan

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.workoutPlanScreen() {
    composable<Destination.WorkoutPlanDestination> {
        WorkoutPlanScreen()
    }
}

fun NavController.navigateToWorkoutPlan() {
    navigate(Destination.WorkoutPlanDestination)
}