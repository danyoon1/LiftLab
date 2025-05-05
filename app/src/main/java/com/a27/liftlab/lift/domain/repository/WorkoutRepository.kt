package com.a27.liftlab.lift.domain.repository

import com.a27.liftlab.lift.domain.models.Exercise
import com.a27.liftlab.lift.domain.models.Workout

interface WorkoutRepository {
    suspend fun getWorkouts(username: String): List<Workout>
    suspend fun getWorkout(username: String, workoutId: String): Workout
    suspend fun updateWorkout(username: String, workoutIndex: Int, exercises: List<Exercise>)
    suspend fun createWorkout(username: String, name: String, difficulty: String, exercises: List<Exercise>): String
}