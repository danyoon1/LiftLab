package com.a27.liftlab.lift.presentation.models

import com.a27.liftlab.lift.domain.models.DietPlan
import com.a27.liftlab.lift.domain.models.Workout

data class DietUi(
    val id: String,
    val name: String,
    val bodyWeight: Int,
    val goal: String,
    val desiredWeight: Int,
    val timeConstraint: String,
    val calPerDay: Int,
    val proteinPerDay: Int,
    val carbPerDay: Int,
    val fatPerDay: Int,
    val otherNotes: List<String>,

)

fun DietPlan.toDietUi(): DietUi {
    return DietUi(
        id = id,
        name = name,
        bodyWeight = bodyWeight,
        goal = goal,
        desiredWeight = desiredWeight,
        timeConstraint = timeConstraint,
        calPerDay = calPerDay,
        proteinPerDay = proteinPerDay,
        carbPerDay = carbPerDay,
        fatPerDay = fatPerDay,
        otherNotes = otherNotes
    )
}