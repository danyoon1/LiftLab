package com.a27.liftlab.lift.presentation.home_route.workout_plan

import android.content.SharedPreferences
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.workoutPlanScreen(
//    username: String,
//    workoutId: String,
    sharedPrefs: SharedPreferences
) {
    composable<Destination.WorkoutPlanDestination> {
        WorkoutPlanScreen(
//            username = username,
//            workoutId = workoutId,
            sharedPrefs = sharedPrefs
        )
    }
}

fun NavController.navigateToWorkoutPlan() {
    navigate(Destination.WorkoutPlanDestination)
}