package com.a27.liftlab.lift.presentation.introduction

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object IntroductionDestination

fun NavGraphBuilder.introductionScreen() {
    composable<IntroductionDestination> {
        IntroductionScreen()
    }
}

fun NavController.navigateToIntroduction() {
    navigate(IntroductionDestination)
}