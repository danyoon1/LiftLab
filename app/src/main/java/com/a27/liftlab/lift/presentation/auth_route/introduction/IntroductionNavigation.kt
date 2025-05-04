package com.a27.liftlab.lift.presentation.auth_route.introduction

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.presentation.navigation.Destination
import kotlinx.serialization.Serializable

fun NavGraphBuilder.introductionScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    composable<Destination.IntroductionDestination> {
        IntroductionScreen(
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToSignUp = onNavigateToSignUp
        )
    }
}

fun NavController.navigateToIntroduction() {
    navigate(Destination.IntroductionDestination)
}