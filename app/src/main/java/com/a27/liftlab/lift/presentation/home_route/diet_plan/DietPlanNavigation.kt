package com.a27.liftlab.lift.presentation.home_route.diet_plan

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.dietPlanScreen() {
    composable<Destination.DietPlanDestination> {
        DietPlanScreen()
    }
}

fun NavController.navigateToDietPlan() {
    navigate(Destination.DietPlanDestination)
}