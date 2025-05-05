package com.a27.liftlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.a27.liftlab.lift.presentation.home_route.generate_workout.generateWorkoutScreen
import com.a27.liftlab.lift.presentation.home_route.generate_workout.navigateToGenerateWorkout
import com.a27.liftlab.lift.presentation.home_route.home.homeScreen
import com.a27.liftlab.lift.presentation.auth_route.introduction.introductionScreen
import com.a27.liftlab.lift.presentation.auth_route.login.loginScreen
import com.a27.liftlab.lift.presentation.auth_route.login.navigateToLoginScreen
import com.a27.liftlab.lift.presentation.auth_route.sign_up.navigateToSignUpScreen
import com.a27.liftlab.lift.presentation.auth_route.sign_up.signUpScreen
import com.a27.liftlab.lift.presentation.home_route.diet_plan.dietPlanScreen
import com.a27.liftlab.lift.presentation.home_route.diet_plan.navigateToDietPlan
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.generateDietPlanScreen
import com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.navigateToGenerateDietPlan
import com.a27.liftlab.lift.presentation.home_route.view_diet_plan.navigateToViewDietPlan
import com.a27.liftlab.lift.presentation.home_route.view_diet_plan.viewDietPlanScreen
import com.a27.liftlab.lift.presentation.nav_bar.BottomNavigationBar
import com.a27.liftlab.lift.presentation.home_route.view_workout.navigateToViewWorkout
import com.a27.liftlab.lift.presentation.home_route.view_workout.viewWorkoutScreen
import com.a27.liftlab.lift.presentation.navigation.Destination
import com.a27.liftlab.lift.presentation.navigation.SubRoute
import com.a27.liftlab.lift.presentation.home_route.workout_plan.navigateToWorkoutPlan
import com.a27.liftlab.lift.presentation.home_route.workout_plan.workoutPlanScreen
import com.a27.liftlab.lift.presentation.home_route.create_workout.navigateToCreateWorkout
import com.a27.liftlab.lift.presentation.home_route.create_workout.createWorkoutScreen
import com.a27.liftlab.lift.presentation.home_route.create_workout.navigateToSelectExercise
import com.a27.liftlab.lift.presentation.home_route.create_workout.navigateToWorkoutEntry
import com.a27.liftlab.lift.presentation.home_route.create_workout.selectExerciseScreen
import com.a27.liftlab.lift.presentation.home_route.create_workout.workoutEntryScreen
import com.a27.liftlab.ui.theme.LiftLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiftLabTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            BottomNavigationBar(navController)
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = SubRoute.AuthRoute,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            navigation<SubRoute.AuthRoute>(
                                startDestination = Destination.IntroductionDestination
                            ) {
                                introductionScreen(
                                    onNavigateToLogin = { navController.navigateToLoginScreen() },
                                    onNavigateToSignUp = { navController.navigateToSignUpScreen() }
                                )
                                loginScreen(
                                    onNavigateToHome = { navController.navigate(SubRoute.HomeRoute) }
                                )
                                signUpScreen(
                                    onNavigateToHome = { navController.navigate(SubRoute.HomeRoute) }
                                )
                            }

                            navigation<SubRoute.HomeRoute>(
                                startDestination = Destination.HomeDestination
                            ) {
                                homeScreen(
                                    onNavigateToViewWorkout = { navController.navigateToViewWorkout() },
                                    onNavigateToGenerateWorkout = { navController.navigateToGenerateWorkout() },
                                    onNavigateToViewDietPlan = { navController.navigateToViewDietPlan() },
                                    onNavigateToCreateWorkout = { navController.navigateToCreateWorkout() },
                                )
                                viewWorkoutScreen()
                                createWorkoutScreen(
                                    onNavigateToWorkoutEntry = { workoutLength, restPeriod ->  navController.navigateToWorkoutEntry(workoutLength, restPeriod) }
                                )
                                workoutEntryScreen(30, 45, onSelectEntry = { index -> navController.navigateToSelectExercise()})
                                selectExerciseScreen(
                                    onExerciseSelected = {navController.navigateToSelectExercise()}
                                )
                                generateWorkoutScreen(
                                    onNavigateToWorkoutPlan = { navController.navigateToWorkoutPlan() }
                                )
                                workoutPlanScreen()
                                viewDietPlanScreen(
                                    onNavigateToGenerateDietPlan = { navController.navigateToGenerateDietPlan() }
                                )
                                generateDietPlanScreen(
                                    onNavigateToDietPlan = { navController.navigateToDietPlan() }
                                )
                                dietPlanScreen()
                            }

                        }
                    }
                }
            }
        }
    }
}
