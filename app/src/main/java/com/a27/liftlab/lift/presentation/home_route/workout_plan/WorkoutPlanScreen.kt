package com.a27.liftlab.lift.presentation.home_route.workout_plan

import android.content.SharedPreferences
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.view_models.WorkoutViewModel
import com.a27.liftlab.lift.presentation.home_route.workout_plan.components.WorkoutExerciseItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutPlanScreen(
//    username: String,
//    workoutId: String,
    sharedPrefs: SharedPreferences,
    modifier: Modifier = Modifier,
    viewModel: WorkoutViewModel = koinViewModel<WorkoutViewModel>(),
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    val workoutUi by viewModel.workout.collectAsState();

    LaunchedEffect(Unit) {
        viewModel.loadWorkout(
            username = sharedPrefs.getString("username", "").toString(),
            workoutId = sharedPrefs.getString("workout", "").toString()
        )
    }

    Log.i("workoutId", sharedPrefs.getString("workout", "").toString())

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
            text = "Name: ${workoutUi?.name}",
            color = contentColor,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(12.dp)
        )

        Text(
            text = "Difficulty: ${workoutUi?.difficulty}",
            color = contentColor,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        workoutUi?.exercises?.forEach {
            WorkoutExerciseItem(it)
            HorizontalDivider()
        }
    }
}