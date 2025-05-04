package com.a27.liftlab.lift.presentation.home_route.workout_plan.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.domain.WorkoutExercise
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun WorkoutExerciseItem(
    workoutExercise: WorkoutExercise,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = contentColor
        )
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = workoutExercise.icon,
                contentDescription = workoutExercise.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(12.dp)
            )

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = workoutExercise.name,
                    color = contentColor,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.padding(12.dp)
                )

                Text(
                    text = "${workoutExercise.reps} Repetitions / ${workoutExercise.sets} Sets",
                    color = contentColor,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun WorkoutExerciseItemPreview() {
    LiftLabTheme {
        WorkoutExerciseItem(
            workoutExercise = WorkoutExercise(
                name = "Curls",
                reps = 5,
                sets = 3,
                icon = ImageVector.vectorResource(R.drawable.dumbbell_simple)
            )
        )
    }
}