package com.a27.liftlab.lift.data.api

import com.a27.liftlab.lift.data.dto.CreateWorkoutRequest
import com.a27.liftlab.lift.data.dto.CreateWorkoutResponse
import com.a27.liftlab.lift.data.dto.LoadWorkoutResponse
import com.a27.liftlab.lift.data.dto.UpdateWorkoutRequest
import com.a27.liftlab.lift.data.dto.WorkoutResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WorkoutApi {
    @GET("workout/loadWorkout")
    suspend fun loadWorkout(
        @Query("username") username: String,
        @Query("workoutId") workoutId: String
    ): LoadWorkoutResponse

    @POST("workout/updateWorkout")
    suspend fun updateWorkout(
        @Body request: UpdateWorkoutRequest
    ): Response<Unit>

    @GET("workout/loadWorkouts")
    suspend fun loadWorkouts(
        @Query("username") username: String
    ): WorkoutResponse

    @POST("workout/createWorkout")
    suspend fun createWorkout(
        @Body request: CreateWorkoutRequest
    ): CreateWorkoutResponse
}