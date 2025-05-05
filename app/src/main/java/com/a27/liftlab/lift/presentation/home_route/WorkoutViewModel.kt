package com.a27.liftlab.lift.presentation.home_route

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a27.liftlab.lift.domain.models.Exercise
import com.a27.liftlab.lift.domain.models.Workout
import com.a27.liftlab.lift.domain.repository.WorkoutRepository
import com.a27.liftlab.lift.presentation.models.ExerciseUi
import com.a27.liftlab.lift.presentation.models.WorkoutUi
import com.a27.liftlab.lift.presentation.models.toExerciseUi
import com.a27.liftlab.lift.presentation.models.toWorkoutUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(
    private val repository: WorkoutRepository
) : ViewModel() {

    private val _workouts = MutableStateFlow<List<WorkoutUi>>(emptyList())
    val workouts: StateFlow<List<WorkoutUi>> = _workouts

    private val _exercises = MutableStateFlow<List<ExerciseUi>>(emptyList())
    val exercises: StateFlow<List<ExerciseUi>> = _exercises

    private val _createdWorkoutId = MutableStateFlow<String?>(null)
    val createdWorkoutId: StateFlow<String?> = _createdWorkoutId

    private val _workout = MutableStateFlow<WorkoutUi?>(null)
    val workout: StateFlow<WorkoutUi?> = _workout

    fun loadWorkouts(username: String) {
        Log.i("load workouts","user workouts loaded")
        viewModelScope.launch {
            _workouts.value = repository.getWorkouts(username).map { it.toWorkoutUi() }
        }
    }

    fun loadWorkout(username: String, workoutId: String) {
        Log.i("load workout","workout loaded")
        viewModelScope.launch {
            _workout.value = repository.getWorkout(username, workoutId).toWorkoutUi()
        }
    }

    fun updateExercises(username: String, workoutIndex: Int, exercises: List<Exercise>) {
        viewModelScope.launch {
            repository.updateWorkout(username, workoutIndex, exercises)
        }
    }

    fun createWorkout(username: String, name: String, difficulty: String, exercises: List<Exercise>) {
        viewModelScope.launch {
            try {
                Log.i("new workout","new workout created")
                val id = repository.createWorkout(username, name, difficulty, exercises)
                _createdWorkoutId.value = id
            } catch (e: Exception) {
                _createdWorkoutId.value = "error"
            }
        }
    }
}