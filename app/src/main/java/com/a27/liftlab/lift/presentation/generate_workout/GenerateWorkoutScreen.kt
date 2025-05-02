package com.a27.liftlab.lift.presentation.generate_workout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.a27.liftlab.lift.presentation.generate_workout.components.GenerateWorkoutButton
import com.a27.liftlab.lift.presentation.generate_workout.components.GenerateWorkoutName
import com.a27.liftlab.lift.presentation.generate_workout.components.WorkoutParameter
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun GenerateWorkoutScreen(
    onNavigateToWorkoutPlan: () -> Unit,
    modifier: Modifier = Modifier,
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

        GenerateWorkoutName()

        WorkoutParameter(
            title = "Goal",
            icon = ImageVector.vectorResource(R.drawable.target),
            dropdownOptions = listOf("Build Strength", "Build Size", "Have Fun")
        )
        WorkoutParameter(
            title = "Duration",
            icon = ImageVector.vectorResource(R.drawable.time),
            dropdownOptions = listOf("15 Minutes", "30 Minutes", "45 Minutes", "1 Hour", "1 Hour 30 Minutes", "2 Hours")
        )
        WorkoutParameter(
            title = "Difficulty",
            icon = ImageVector.vectorResource(R.drawable.difficulty),
            dropdownOptions = listOf("Beginner", "Intermediate", "Advanced")
        )
        WorkoutParameter(
            title = "Weight",
            icon = ImageVector.vectorResource(R.drawable.body_weight),
            dropdownOptions = listOf("Skinny", "Normal", "Fat")
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GenerateWorkoutButton(
                title = "Generate Workout",
                onAction = onNavigateToWorkoutPlan
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun GenerateWorkoutScreenPreview() {
    LiftLabTheme {
        GenerateWorkoutScreen({})
    }
}