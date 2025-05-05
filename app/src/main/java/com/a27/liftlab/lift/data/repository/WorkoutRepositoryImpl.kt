package com.a27.liftlab.lift.data.repository

import android.util.Log
import com.a27.liftlab.lift.data.api.WorkoutApi
import com.a27.liftlab.lift.data.dto.CreateWorkoutRequest
import com.a27.liftlab.lift.data.dto.UpdateWorkoutRequest
import com.a27.liftlab.lift.domain.mappers.toDomain
import com.a27.liftlab.lift.domain.mappers.toDto
import com.a27.liftlab.lift.domain.models.Exercise
import com.a27.liftlab.lift.domain.models.Workout
import com.a27.liftlab.lift.domain.repository.WorkoutRepository

class WorkoutRepositoryImpl(
    private val api: WorkoutApi
) : WorkoutRepository {

    override suspend fun getWorkouts(username: String): List<Workout> {
        val response = api.loadWorkouts(username).workouts.map { workoutDto -> workoutDto.toDomain() }
        Log.i("get response", response.toString())
        return response
    }

    override suspend fun getWorkout(username: String, workoutId: String): Workout {
        return api.loadWorkout(username, workoutId).selectedWorkout.toDomain()
    }

    override suspend fun updateWorkout(username: String, workoutIndex: Int, exercises: List<Exercise>) {
        val request = UpdateWorkoutRequest(
            username = username,
            workout = workoutIndex,
            exerciseArray = exercises.map { exercise -> exercise.toDto() }
        )
        api.updateWorkout(request)
    }

    override suspend fun createWorkout(username: String, name: String, difficulty: String, exercises: List<Exercise>): String {
        val request = CreateWorkoutRequest(
            username = username,
            name = name,
            difficulty = difficulty,
            exerciseArray = exercises.map { it.toDto() }
        )
        return api.createWorkout(request).workoutId
    }
}