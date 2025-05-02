package com.a27.liftlab.lift.presentation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HomeDestination

fun NavGraphBuilder.homeScreen(
    onNavigateToViewWorkout: () -> Unit,
    onNavigateToGenerateWorkout: () -> Unit
) {
    composable<HomeDestination> {
        HomeScreen(
            onNavigateToViewWorkout = onNavigateToViewWorkout,
            onNavigateToGenerateWorkout = onNavigateToGenerateWorkout
        )
    }
}

fun NavController.navigateToHome() {
    navigate(HomeDestination)
}