package com.a27.liftlab.lift.presentation.home_route.generate_workout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.domain.models.Exercise
import com.a27.liftlab.lift.presentation.view_models.WorkoutViewModel
import com.a27.liftlab.lift.presentation.home_route.generate_workout.components.GenerateWorkoutButton
import com.a27.liftlab.lift.presentation.home_route.generate_workout.components.GenerateWorkoutName
import com.a27.liftlab.lift.presentation.home_route.generate_workout.components.WorkoutParameter
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun GenerateWorkoutScreen(
    onNavigateToWorkoutPlan: () -> Unit,
    username: String,
    modifier: Modifier = Modifier,
    viewModel: WorkoutViewModel = koinViewModel<WorkoutViewModel>(),
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Generate Workout",
                color = contentColor,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        var workoutName by remember { mutableStateOf("") }
        GenerateWorkoutName(
            value = workoutName,
            onValueChange = { workoutName = it }
        )

        var selectedGoal by remember { mutableStateOf("Goal") }
        WorkoutParameter(
            title = "Goal",
            icon = ImageVector.vectorResource(R.drawable.target),
            dropdownOptions = listOf("Build Strength", "Build Size", "Have Fun"),
            selectedOption = selectedGoal,
            onOptionSelected = { selectedGoal = it }
        )

        var selectedDuration by remember { mutableStateOf("Duration") }
        WorkoutParameter(
            title = "Duration",
            icon = ImageVector.vectorResource(R.drawable.time),
            dropdownOptions = listOf("15 Minutes", "30 Minutes", "45 Minutes", "1 Hour", "1 Hour 30 Minutes", "2 Hours"),
            selectedOption = selectedDuration,
            onOptionSelected = { selectedDuration = it }
        )

        var selectedDifficulty by remember { mutableStateOf("Difficulty") }
        WorkoutParameter(
            title = "Difficulty",
            icon = ImageVector.vectorResource(R.drawable.difficulty),
            dropdownOptions = listOf("Beginner", "Intermediate", "Advanced"),
            selectedOption = selectedDifficulty,
            onOptionSelected = { selectedDifficulty = it }
        )

        var selectedWeight by remember { mutableStateOf("Weight") }
        WorkoutParameter(
            title = "Weight",
            icon = ImageVector.vectorResource(R.drawable.body_weight),
            dropdownOptions = listOf("Skinny", "Normal", "Fat"),
            selectedOption = selectedWeight,
            onOptionSelected = { selectedWeight = it }
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GenerateWorkoutButton(
                title = "Generate Workout",
                onAction = {
                    onNavigateToWorkoutPlan()
                    viewModel.createWorkout(
                        username = username,
                        difficulty = "insane",
                        name = "get big workout",
                        exercises = listOf(
                            Exercise(
                                id = "id1",
                                name = "dry humps",
                                reps = 10,
                                sets = 5
                            ),
                            Exercise(
                                id = "id2",
                                name = "bench",
                                reps = 15,
                                sets = 3
                            )
                        )
                    )
                }
            )
        }
    }
}