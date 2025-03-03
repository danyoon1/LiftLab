package com.example.liftlab.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(navigateScreen: (screen: String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(18.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().height(80.dp),
                text = Routes.WELCOME_SCREEN
            )

            Spacer(
                modifier = Modifier.size(20.dp)
            )

            // LOGIN BUTTON
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navigateScreen(Routes.LOGIN_SCREEN)
                }
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            Spacer(
                modifier = Modifier.size(20.dp)
            )

            // REGISTER BUTTON
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navigateScreen(Routes.REGISTER_SCREEN)
                }
            ) {
                Text(
                    text = "Register",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            Spacer(
                modifier = Modifier.size(20.dp)
            )

            // DASHBOARD BUTTON
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navigateScreen(Routes.DASHBOARD_SCREEN)
                }
            ) {
                Text(
                    text = "Dashboard",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun WelcomeScreenPreview() {
//    WelcomeScreen()
//}