package com.a27.liftlab.lift.domain.mappers

import com.a27.liftlab.lift.data.dto.DietDto
import com.a27.liftlab.lift.domain.models.DietPlan

fun DietDto.toDomain(): DietPlan = DietPlan(
    id = _id,
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