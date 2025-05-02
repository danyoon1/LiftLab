package com.a27.liftlab.lift.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.home.components.HomeButton
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun HomeScreen(
    onNavigateToViewWorkout: () -> Unit,
    onNavigateToGenerateWorkout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.liftlab_logo),
            contentDescription = "liftlab logo",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 10.dp)
        )

        Text(
            text = "Lift Lab",
            color = Color(0xFF4285F4),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 60.sp,
            lineHeight = 60.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        HomeButton(
            title = "View Workouts",
            onAction = onNavigateToViewWorkout
        )

        HomeButton(
            title = "Generate Workout",
            onAction = onNavigateToGenerateWorkout
        )

        HomeButton(
            title = "View Diet Plans",
            onAction = onNavigateToViewWorkout
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    LiftLabTheme {
        HomeScreen(
            onNavigateToViewWorkout = {},
            onNavigateToGenerateWorkout = {}
        )
    }
}