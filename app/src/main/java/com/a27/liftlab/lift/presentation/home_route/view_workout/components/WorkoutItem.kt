package com.a27.liftlab.lift.presentation.home_route.view_workout.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.a27.liftlab.ui.theme.LiftLabTheme

@Composable
fun WorkoutItem(
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(50.dp),
        shape = RectangleShape,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Text(
            text = title
        )
    }
}

@Preview
@Composable
private fun WorkoutItemPreview() {
    LiftLabTheme {
        WorkoutItem("Workout item")
    }
}