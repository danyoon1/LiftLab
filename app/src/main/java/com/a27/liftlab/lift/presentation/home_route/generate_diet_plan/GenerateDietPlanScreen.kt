package com.a27.liftlab.lift.presentation.home_route.generate_diet_plan

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
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.DietInputField
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.DietParameter
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.GenerateDietPlanButton
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.GenerateDietPlanName
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun GenerateDietPlanScreen(
    onNavigateToDietPlan: () -> Unit,
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
                text = "Generate New Diet",
                color = contentColor,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        GenerateDietPlanName()

        DietInputField(
            title = "Current Weight",
            icon = ImageVector.vectorResource(R.drawable.body_weight)
        )
        DietParameter(
            title = "Goal",
            icon = ImageVector.vectorResource(R.drawable.target),
            dropdownOptions = listOf("Lose Weight", "Gain Weight", "Lean Bulk", "Dirty Bulk", "Cut")
        )
        DietInputField(
            title = "Desired Weight",
            icon = ImageVector.vectorResource(R.drawable.body)
        )
        DietParameter(
            title = "Time Constraint",
            icon = ImageVector.vectorResource(R.drawable.time),
            dropdownOptions = listOf("1 Month", "2 Months", "3 Months", "6 Months", "1 year")
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GenerateDietPlanButton(
                title = "Generate Diet Plan",
                onAction = { onNavigateToDietPlan() }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun GenerateWorkoutScreenPreview() {
    LiftLabTheme {
        GenerateDietPlanScreen({})
    }
}