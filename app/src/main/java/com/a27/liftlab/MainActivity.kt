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
import androidx.navigation.compose.rememberNavController
import com.a27.liftlab.lift.presentation.home.HomeDestination
import com.a27.liftlab.lift.presentation.home.homeScreen
import com.a27.liftlab.lift.presentation.introduction.introductionScreen
import com.a27.liftlab.lift.presentation.navigation.BottomNavigationBar
import com.a27.liftlab.lift.presentation.view_workout.ViewWorkoutDestination
import com.a27.liftlab.lift.presentation.view_workout.viewWorkoutScreen
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
                            startDestination = ViewWorkoutDestination,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            homeScreen()
                            introductionScreen()
                            viewWorkoutScreen()
                        }
                    }
                }
            }
        }
    }
}
