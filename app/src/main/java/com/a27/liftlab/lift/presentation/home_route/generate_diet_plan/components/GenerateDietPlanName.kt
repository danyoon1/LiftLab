package com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.ui.theme.LiftLabTheme

@Composable
fun GenerateDietPlanName(
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(12.dp)
    ) {
        Text(
            text = "Diet Plan Name",
            fontSize = 10.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("(Required)") }
        )
    }
}

@PreviewLightDark
@Composable
private fun GenerateWorkoutNamePreview() {
    LiftLabTheme {
        GenerateDietPlanName()
    }
}