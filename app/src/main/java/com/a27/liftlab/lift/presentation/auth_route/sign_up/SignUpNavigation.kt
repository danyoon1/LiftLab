package com.a27.liftlab.lift.presentation.auth_route.sign_up

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination

fun NavGraphBuilder.signUpScreen(
    onNavigateToHome: () -> Unit
) {
    composable<Destination.SignUpDestination> {
        SignUpScreen(
            onNavigateToHome = onNavigateToHome
        )
    }
}

fun NavController.navigateToSignUpScreen() {
    navigate(Destination.SignUpDestination)
}