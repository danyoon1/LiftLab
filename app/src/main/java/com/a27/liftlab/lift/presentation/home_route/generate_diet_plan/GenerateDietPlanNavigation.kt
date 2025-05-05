package com.a27.liftlab.lift.presentation.home_route.generate_diet_plan

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.generateDietPlanScreen(
    onNavigateToDietPlan: (dietId: String) -> Unit,
    username: String
) {
    composable<Destination.GenerateDietPlanDestination> {
        GenerateDietPlanScreen(
            onNavigateToDietPlan = onNavigateToDietPlan,
            username = username
        )
    }
}

fun NavController.navigateToGenerateDietPlan() {
    navigate(Destination.GenerateDietPlanDestination)
}