package com.a27.liftlab.lift.presentation.auth_route.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.loginScreen(
    onNavigateToHome: () -> Unit
) {
    composable<Destination.LoginDestination> {
        LoginScreen(
            onNavigateToHome = onNavigateToHome
        )
    }
}

fun NavController.navigateToLoginScreen() {
    navigate(Destination.LoginDestination)
}