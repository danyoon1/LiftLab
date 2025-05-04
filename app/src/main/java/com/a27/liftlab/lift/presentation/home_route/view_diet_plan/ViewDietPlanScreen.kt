package com.a27.liftlab.lift.presentation.home_route.view_diet_plan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.home_route.view_diet_plan.components.ViewDietPlanButton
import com.a27.liftlab.lift.presentation.home_route.view_diet_plan.components.ViewDietPlanItem
import com.a27.liftlab.ui.theme.LiftLabTheme

@Composable
fun ViewDietPlanScreen(
    onNavigateToGenerateDietPlan: () -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    val tempWorkoutItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    Column (
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Diet Plans",
            color = contentColor,
            fontSize = 20.sp
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tempWorkoutItems) { item ->
                ViewDietPlanItem(item)
                HorizontalDivider()
            }
        }

        ViewDietPlanButton(
            title = "Generate New Diet",
            onAction = onNavigateToGenerateDietPlan
        )
    }
}

@PreviewLightDark
@Composable
private fun ViewDietPlanScreenPreview() {
    LiftLabTheme {
        ViewDietPlanScreen(
            onNavigateToGenerateDietPlan = {}
        )
    }
}