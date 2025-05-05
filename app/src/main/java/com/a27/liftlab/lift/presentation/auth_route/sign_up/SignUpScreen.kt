package com.a27.liftlab.lift.presentation.auth_route.sign_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.auth_route.sign_up.components.SignUpButton
import com.a27.liftlab.lift.presentation.view_models.AuthViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = koinViewModel<AuthViewModel>(),
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val authStatus by viewModel.authStatus.collectAsState()

    Column(
        modifier = modifier
            .padding(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Sign Up",
            color = contentColor,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "Username",
            fontSize = 10.sp,
            color = contentColor
        )

        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text("(Username)") }
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "Password",
            fontSize = 10.sp,
            color = contentColor
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("(Password)") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "Confirm Password",
            fontSize = 10.sp,
            color = contentColor
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword = it},
            label = { Text("(Confirm Password)") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(15.dp))

        SignUpButton(
            title = "Sign Up",
            onAction = {
                if (password == confirmPassword) {
                    viewModel.register(
                        user = username,
                        password = password
                    ) { success ->
                        if (success) {
                            onNavigateToHome()
                        }
                    }
                }
            }
        )
    }
}