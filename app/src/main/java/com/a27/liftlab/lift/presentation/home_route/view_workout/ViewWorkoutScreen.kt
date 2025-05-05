package com.a27.liftlab.lift.presentation.home_route.view_workout

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.view_models.WorkoutViewModel
import com.a27.liftlab.lift.presentation.home_route.view_workout.components.ViewWorkoutButton
import com.a27.liftlab.lift.presentation.home_route.view_workout.components.ViewWorkoutItem
import com.a27.liftlab.ui.theme.LiftLabTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ViewWorkoutScreen(
    username: String,
    onNavigateToWorkoutPlan: (workoutId: String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WorkoutViewModel = koinViewModel<WorkoutViewModel>(),
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
//    val tempWorkoutItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    val workouts by viewModel.workouts.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadWorkouts(username)
    }

    Column (
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Workouts",
            color = contentColor,
            fontSize = 20.sp
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(workouts) { item ->
                ViewWorkoutItem(
                    title = item.name,
                    onSelectedWorkout = {
                        onNavigateToWorkoutPlan(item.id)
                    }
                )
                HorizontalDivider()
            }
        }

        ViewWorkoutButton("View Schedule")
    }
}