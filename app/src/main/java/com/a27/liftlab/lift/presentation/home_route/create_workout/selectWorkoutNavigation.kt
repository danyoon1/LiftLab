package com.a27.liftlab.lift.presentation.home_route.create_workout

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.a27.liftlab.lift.presentation.navigation.Destination
import kotlinx.serialization.Serializable

fun NavGraphBuilder.selectExerciseScreen(
    onExerciseSelected: (String) -> Unit
) {
    composable<Destination.SelectExerciseDestination> {
        SelectExerciseScreen(
            onExerciseSelected = onExerciseSelected
        )
    }
}

fun NavController.navigateToSelectExercise() {
    navigate(Destination.SelectExerciseDestination)
}