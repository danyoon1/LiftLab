package com.a27.liftlab.lift.presentation.home_route.generate_diet_plan

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.generateDietPlanScreen(
    onNavigateToDietPlan: () -> Unit
) {
    composable<Destination.GenerateDietPlanDestination> {
        GenerateDietPlanScreen(
            onNavigateToDietPlan = onNavigateToDietPlan
        )
    }
}

fun NavController.navigateToGenerateDietPlan() {
    navigate(Destination.GenerateDietPlanDestination)
}