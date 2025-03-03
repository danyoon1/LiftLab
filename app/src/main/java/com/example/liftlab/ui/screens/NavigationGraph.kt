package com.example.liftlab.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navigateScreen = {
                screen -> navController.navigate(screen)
            })
        }

        composable(Routes.LOGIN_SCREEN) {
            LoginScreen()
        }

        composable(Routes.REGISTER_SCREEN) {
            RegisterScreen()
        }

        composable(Routes.DASHBOARD_SCREEN) {
            DashboardScreen()
        }
    }
}