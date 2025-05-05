package com.a27.liftlab.lift.presentation.navigation

import kotlinx.serialization.Serializable

sealed class SubRoute {

    @Serializable
    data object AuthRoute: SubRoute()

    @Serializable
    data object HomeRoute: SubRoute()

}

sealed class Destination {

    @Serializable
    data object IntroductionDestination: Destination()

    @Serializable
    data object LoginDestination: Destination()

    @Serializable
    data object SignUpDestination: Destination()

    @Serializable
    data object HomeDestination: Destination()

    @Serializable
    data object ViewWorkoutDestination: Destination()

    @Serializable
    data object GenerateWorkoutDestination: Destination()

    @Serializable
    data object WorkoutPlanDestination: Destination()

    @Serializable
    data object ViewDietPlanDestination: Destination()

    @Serializable
    data object GenerateDietPlanDestination: Destination()

    @Serializable
    data object CreateWorkoutDestination: Destination()

    @Serializable
    data object DietPlanDestination: Destination()

    @Serializable
    data object SelectExerciseDestination: Destination()

    @Serializable
    data object WorkoutEntryDestination: Destination()

}