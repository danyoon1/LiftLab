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
import com.a27.liftlab.lift.presentation.home_route.create_workout.components.CreateWorkoutButton
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController


@Composable
fun CreateWorkoutScreen(
    onNavigateToWorkoutEntry: (workoutLength: Int, restPeriod: Int) -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    val navController = rememberNavController()
    var workoutName by remember { mutableStateOf("New Workout")}
    var workoutLength by remember { mutableStateOf(30f) }
    var restPeriod by remember { mutableStateOf(5f)}

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Create a New Workout",
            style = MaterialTheme.typography.titleLarge,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Workout Name",
            style = MaterialTheme.typography.titleMedium,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = workoutName,
            onValueChange = { workoutName = it },
            placeholder = { Text("Enter workout name") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Select Workout Length",
            style = MaterialTheme.typography.titleMedium,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Determines How Many Exercises to Include",
            style = MaterialTheme.typography.titleSmall,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = workoutLength,
            onValueChange = { workoutLength = it },
            valueRange = 10f..120f,
            steps = 10,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "${workoutLength.toInt()} minutes",
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Select Rest Interval",
            style = MaterialTheme.typography.titleMedium,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "How Long Each Rest Period Is",
            style = MaterialTheme.typography.titleSmall,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = restPeriod,
            onValueChange = { restPeriod = it },
            valueRange = 5f..120f,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "${restPeriod.toInt()} seconds",
            style = MaterialTheme.typography.bodyLarge,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        CreateWorkoutButton("Select Exercises", onAction = {onNavigateToWorkoutEntry(workoutLength.toInt(), restPeriod.toInt())})

    }
}



//@PreviewLightDark
//@Composable
//private fun CreateWorkoutScreenPreview() {
//    LiftLabTheme {
//        CreateWorkoutScreen(
//            onNavigateToWorkoutEntry = {}
//        )
//    }
//}