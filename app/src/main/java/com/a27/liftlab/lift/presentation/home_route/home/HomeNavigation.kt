package com.a27.liftlab.lift.presentation.home_route.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination
import kotlinx.serialization.Serializable

fun NavGraphBuilder.homeScreen(
    onNavigateToViewWorkout: () -> Unit,
    onNavigateToGenerateWorkout: () -> Unit
) {
    composable<Destination.HomeDestination> {
        HomeScreen(
            onNavigateToViewWorkout = onNavigateToViewWorkout,
            onNavigateToGenerateWorkout = onNavigateToGenerateWorkout
        )
    }
}

fun NavController.navigateToHome() {
    navigate(Destination.HomeDestination)
}