package com.a27.liftlab.lift.presentation.workout_plan

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a27.liftlab.lift.domain.WorkoutExercise
import com.a27.liftlab.lift.domain.WorkoutPlan
import com.example.liftlab.R
import kotlinx.serialization.Serializable

@Serializable
data object WorkoutPlanDestination

fun NavGraphBuilder.workoutPlanScreen() {
    composable<WorkoutPlanDestination> {
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
    navigate(WorkoutPlanDestination)
}