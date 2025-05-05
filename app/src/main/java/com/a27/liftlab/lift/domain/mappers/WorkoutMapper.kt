package com.a27.liftlab.lift.domain.mappers

import com.a27.liftlab.lift.data.dto.ExerciseDto
import com.a27.liftlab.lift.data.dto.WorkoutDto
import com.a27.liftlab.lift.domain.models.Exercise
import com.a27.liftlab.lift.domain.models.Workout

fun ExerciseDto.toDomain(): Exercise = Exercise(
    id = _id,
    name = name,
    reps = reps,
    sets = sets
)
fun Exercise.toDto(): ExerciseDto = ExerciseDto(
    _id = id,
    name = name,
    reps = reps,
    sets = sets
)

fun WorkoutDto.toDomain(): Workout = Workout(
    id = _id,
    name = name,
    difficulty = difficulty,
    exercises = exercises.map { it.toDomain() }
)