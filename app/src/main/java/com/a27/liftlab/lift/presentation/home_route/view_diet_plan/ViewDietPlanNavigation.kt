package com.a27.liftlab.lift.presentation.home_route.view_diet_plan

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.viewDietPlanScreen(
    onNavigateToGenerateDietPlan: () -> Unit
) {
    composable<Destination.ViewDietPlanDestination> {
        ViewDietPlanScreen(
            onNavigateToGenerateDietPlan = onNavigateToGenerateDietPlan
        )
    }
}

fun NavController.navigateToViewDietPlan() {
    navigate(Destination.ViewDietPlanDestination)
}