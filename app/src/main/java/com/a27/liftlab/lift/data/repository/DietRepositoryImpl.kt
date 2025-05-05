package com.a27.liftlab.lift.data.repository

import com.a27.liftlab.lift.data.api.DietApi
import com.a27.liftlab.lift.data.dto.CreateDietRequest
import com.a27.liftlab.lift.domain.mappers.toDomain
import com.a27.liftlab.lift.domain.models.DietPlan
import com.a27.liftlab.lift.domain.repository.DietRepository

class DietRepositoryImpl(private val api: DietApi) : DietRepository {
    override suspend fun loadDiets(username: String): List<DietPlan> {
        return api.loadDiets(username).diets.map { it.toDomain() }
    }

    override suspend fun loadDiet(username: String, dietId: String): DietPlan {
        return api.loadDiet(username, dietId).selectedDiet.toDomain()
    }

    override suspend fun createDiet(request: CreateDietRequest): String {
        return api.createDiet(request).dietId
    }
}