package com.a27.liftlab.lift.presentation.home_route.workout_plan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.domain.WorkoutExercise
import com.a27.liftlab.lift.domain.WorkoutPlan
import com.a27.liftlab.lift.presentation.home_route.workout_plan.components.WorkoutExerciseItem
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun WorkoutPlanScreen(
    workoutPlan: WorkoutPlan,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Workout Plan",
                color = contentColor,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "Name: ${workoutPlan.name}",
            color = contentColor,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(12.dp)
        )

        Text(
            text = "Difficulty: ${workoutPlan.difficulty}",
            color = contentColor,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        workoutPlan.exercises.forEach {
            WorkoutExerciseItem(it)
            HorizontalDivider()
        }
    }
}

@PreviewLightDark
@Composable
private fun WorkoutPlanScreenPreview() {
    LiftLabTheme {
        WorkoutPlanScreen(
            WorkoutPlan(
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