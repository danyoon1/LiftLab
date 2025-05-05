package com.a27.liftlab

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
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
import com.a27.liftlab.ui.theme.LiftLabTheme

class MainActivity : ComponentActivity() {
    val sharedPrefs by lazy {
        getSharedPreferences(
            "_sharedPreferences",
            Context.MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiftLabTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            val showBottomBar = when (navBackStackEntry?.destination?.route.toString()) {
                                "com.a27.liftlab.lift.presentation.navigation.Destination.IntroductionDestination" -> false
                                "com.a27.liftlab.lift.presentation.navigation.Destination.LoginDestination" -> false
                                "com.a27.liftlab.lift.presentation.navigation.Destination.SignUpDestination" -> false
                                else -> true
                            }
                            if (showBottomBar) {
                                BottomNavigationBar(navController)
                            }
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
                                    onNavigateToHome = { navController.navigate(SubRoute.HomeRoute) },
                                    onLoginSuccessful = { sharedPrefs.edit().putString("username", it).apply() }
                                )
                                signUpScreen(
                                    onNavigateToHome = { navController.navigate(SubRoute.HomeRoute) },
                                    onSignUpSuccessful = { sharedPrefs.edit().putString("username", it).apply() }
                                )
                            }

                            navigation<SubRoute.HomeRoute>(
                                startDestination = Destination.HomeDestination
                            ) {
                                homeScreen(
                                    onNavigateToViewWorkout = { navController.navigateToViewWorkout() },
                                    onNavigateToGenerateWorkout = { navController.navigateToGenerateWorkout() },
                                    onNavigateToViewDietPlan = { navController.navigateToViewDietPlan() }
                                )
                                viewWorkoutScreen(
                                    username = sharedPrefs.getString("username", "").toString(),
                                    onNavigateToWorkoutPlan = {
                                        sharedPrefs.edit().putString("workout", it).apply()
                                        navController.navigate(SubRoute.WorkoutRoute)
                                    }
                                )
                                generateWorkoutScreen(
                                    onNavigateToWorkoutPlan = { navController.navigate(SubRoute.WorkoutRoute) },
                                    username = sharedPrefs.getString("username", "").toString()
                                )
                                viewDietPlanScreen(
                                    onNavigateToGenerateDietPlan = { navController.navigateToGenerateDietPlan() }
                                )
                                generateDietPlanScreen(
                                    onNavigateToDietPlan = { navController.navigateToDietPlan() }
                                )
                                dietPlanScreen()
                            }

                            navigation<SubRoute.WorkoutRoute>(
                                startDestination = Destination.WorkoutPlanDestination
                            ) {
                                workoutPlanScreen(
//                                    username = sharedPrefs.getString("username", "").toString(),
//                                    workoutId = sharedPrefs.getString("workout", "").toString(),
                                    sharedPrefs
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}
