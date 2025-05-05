package com.a27.liftlab.lift.presentation.home_route.view_diet_plan

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.viewDietPlanScreen(
    username: String,
    onNavigateToGenerateDietPlan: () -> Unit,
    onNavigateToDietPlan: (workoutId: String) -> Unit
) {
    composable<Destination.ViewDietPlanDestination> {
        ViewDietPlanScreen(
            username = username,
            onNavigateToGenerateDietPlan = onNavigateToGenerateDietPlan,
            onNavigateToDietPlan = onNavigateToDietPlan
        )
    }
}

fun NavController.navigateToViewDietPlan() {
    navigate(Destination.ViewDietPlanDestination)
}