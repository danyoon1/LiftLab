package com.a27.liftlab.lift.data.dto

data class DietDto(
    val _id: String,
    val name: String,
    val bodyWeight: Int,
    val goal: String,
    val desiredWeight: Int,
    val timeConstraint: String,
    val calPerDay: Int,
    val proteinPerDay: Int,
    val carbPerDay: Int,
    val fatPerDay: Int,
    val otherNotes: List<String>
)