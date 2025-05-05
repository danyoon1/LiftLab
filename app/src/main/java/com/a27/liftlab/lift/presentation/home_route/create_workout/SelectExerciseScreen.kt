package com.a27.liftlab.lift.presentation.home_route.create_workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.home_route.view_workout.ViewWorkoutScreen
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.a27.liftlab.lift.presentation.home_route.create_workout.components.ExerciseBanner
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SelectExerciseScreen(
    onExerciseSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val exercises = listOf(
        "Push-ups", "Squats",
        "Lunges", "Plank",
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(exercises) { exercise ->
            ExerciseBanner(
                exerciseName = exercise,
                onClick = { onExerciseSelected(exercise) }
            )
        }
    }
}