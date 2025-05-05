package com.a27.liftlab.lift.domain.repository

import com.a27.liftlab.lift.data.dto.CreateDietRequest
import com.a27.liftlab.lift.domain.models.DietPlan

interface DietRepository {
    suspend fun loadDiets(username: String): List<DietPlan>
    suspend fun loadDiet(username: String, dietId: String): DietPlan
    suspend fun createDiet(request: CreateDietRequest): String
}
