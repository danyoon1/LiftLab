package com.a27.liftlab.lift.presentation.home_route.diet_plan

import androidx.compose.runtime.Composable
import com.a27.liftlab.lift.domain.DietPlan
import com.a27.liftlab.lift.presentation.home_route.diet_plan.components.DietPlanItem

@Composable
fun DietPlanScreen() {
    DietPlanItem(
        dietPlan = DietPlan(
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
    )
}