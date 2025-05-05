package com.a27.liftlab.lift.presentation.home_route.create_workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.clickable

sealed class WorkoutEntry{
    data class Exercise(val name: String = "") : WorkoutEntry()
    data class Rest(val duration: Int) : WorkoutEntry()
}

@Composable
fun WorkoutEntryScreen(
    workoutLength: Int,
    restPeriod: Int,
    onSelectEntry: (Int) -> Unit // called when an exercise slot is tapped
) {
    val totalEntries = (workoutLength * 60) / (restPeriod) // Estimate
    val entries = remember {
        List(totalEntries * 2 - 1) { index ->
            if (index % 2 == 0) WorkoutEntry.Exercise()
            else WorkoutEntry.Rest(restPeriod)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(entries) { index, entry ->
            Column {
                when (entry) {
                    is WorkoutEntry.Exercise -> ExerciseEntry(index, entry.name) {
                        onSelectEntry(index)
                    }

                    is WorkoutEntry.Rest -> RestEntry(entry.duration)
                }

                HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun ExerciseEntry(index: Int, name: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() }
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = if (name.isNotEmpty()) name else "Tap to select exercise", fontSize = 18.sp)
    }
}

@Composable
fun RestEntry(duration: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = "Rest - $duration sec", fontSize = 16.sp, color = Color.Gray)
    }
}