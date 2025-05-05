package com.a27.liftlab.lift.presentation.home_route.diet_plan

import android.content.SharedPreferences
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.dietPlanScreen(
    sharedPrefs: SharedPreferences
) {
    composable<Destination.DietPlanDestination> {
        DietPlanScreen(
            sharedPrefs = sharedPrefs
        )
    }
}

fun NavController.navigateToDietPlan() {
    navigate(Destination.DietPlanDestination)
}