package com.a27.liftlab.lift.presentation.home_route.diet_plan

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.a27.liftlab.lift.domain.models.DietPlan
import com.a27.liftlab.lift.presentation.home_route.diet_plan.components.DietPlanItem
import com.a27.liftlab.lift.presentation.models.DietUi
import com.a27.liftlab.lift.presentation.view_models.DietViewModel
import com.a27.liftlab.lift.presentation.view_models.WorkoutViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DietPlanScreen(
    sharedPrefs: SharedPreferences,
    viewModel: DietViewModel = koinViewModel<DietViewModel>()
) {
    val dietUi by viewModel.selectedDiet.collectAsState();

    LaunchedEffect(Unit) {
        viewModel.loadDiet(
            username = sharedPrefs.getString("username", "").toString(),
            dietId = sharedPrefs.getString("diet", "").toString()
        )
    }

    dietUi?.let {
        DietPlanItem(
//        dietUi = DietUi(
//            id = "id1",
//            name = "Get strong plan",
//            bodyWeight = 150,
//            goal = "Get big",
//            desiredWeight = 200,
//            timeConstraint = "3 Months",
//            calPerDay = 3000,
//            proteinPerDay = 200,
//            carbPerDay = 350,
//            fatPerDay = 100,
//            otherNotes = listOf("Eat fruits", "Eat vegetables")
//        )
        dietUi = it
    )
    }
}