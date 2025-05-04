package com.a27.liftlab.lift.presentation.home_route.workout_plan

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.domain.WorkoutExercise
import com.a27.liftlab.lift.domain.WorkoutPlan
import com.a27.liftlab.lift.presentation.navigation.Destination
import com.example.liftlab.R
import kotlinx.serialization.Serializable

fun NavGraphBuilder.workoutPlanScreen() {
    composable<Destination.WorkoutPlanDestination> {
        WorkoutPlanScreen(
            workoutPlan = WorkoutPlan(
                name = "Push Day",
                difficulty = "Intermediate",
                exercises = listOf(
                    WorkoutExercise(
                        name = "Curls",
                        reps = 5,
                        sets = 3,
                        icon = ImageVector.vectorResource(R.drawable.dumbbell_simple)
                    ),
                    WorkoutExercise(
                        name = "Curls",
                        reps = 5,
                        sets = 3,
                        icon = ImageVector.vectorResource(R.drawable.dumbbell_simple)
                    ),
                    WorkoutExercise(
                        name = "Curls",
                        reps = 5,
                        sets = 3,
                        icon = ImageVector.vectorResource(R.drawable.dumbbell_simple)
                    )
                )
            )
        )
    }
}

fun NavController.navigateToWorkoutPlan() {
    navigate(Destination.WorkoutPlanDestination)
}