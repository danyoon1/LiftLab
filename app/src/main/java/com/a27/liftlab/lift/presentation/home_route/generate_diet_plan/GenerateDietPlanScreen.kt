package com.a27.liftlab.lift.presentation.home_route.generate_diet_plan

import android.util.Log
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
import com.a27.liftlab.lift.data.dto.CreateDietRequest
import com.a27.liftlab.lift.domain.models.Exercise
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.DietInputField
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.DietParameter
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.GenerateDietPlanButton
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components.GenerateDietPlanName
import com.a27.liftlab.lift.presentation.view_models.DietViewModel
import com.a27.liftlab.lift.presentation.view_models.WorkoutViewModel
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun GenerateDietPlanScreen(
    onNavigateToDietPlan: (dietId: String) -> Unit,
    username: String,
    modifier: Modifier = Modifier,
    viewModel: DietViewModel = koinViewModel<DietViewModel>(),
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
                onAction = {
                    viewModel.createDiet(
                        CreateDietRequest(
                            username = username,
                            name = "Get strong plan",
                            bodyWeight = 150,
                            goal = "Get big",
                            desiredWeight = 200,
                            timeConstraint = "3 Months",
                            calPerDay = 3000,
                            proteinPerDay = 200,
                            carbPerDay = 350,
                            fatPerDay = 100,
                            otherNotes = listOf("Eat fruits", "Eat vegetables")
                        )
                    ) { newId ->
                        onNavigateToDietPlan(newId)
                    }
                }
            )

        }
    }
}