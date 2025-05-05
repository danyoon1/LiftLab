package com.a27.liftlab.lift.data.api

import com.a27.liftlab.lift.data.dto.CreateDietRequest
import com.a27.liftlab.lift.data.dto.CreateDietResponse
import com.a27.liftlab.lift.data.dto.DietResponse
import com.a27.liftlab.lift.data.dto.DietsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DietApi {
    @GET("diet/loadDiets")
    suspend fun loadDiets(@Query("username") username: String): DietsResponse

    @GET("diet/loadDiet")
    suspend fun loadDiet(
        @Query("username") username: String,
        @Query("dietId") dietId: String
    ): DietResponse

    @POST("diet/createDiet")
    suspend fun createDiet(@Body request: CreateDietRequest): CreateDietResponse
}