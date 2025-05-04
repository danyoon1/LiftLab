package com.a27.liftlab.lift.presentation.auth_route.introduction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.presentation.auth_route.introduction.components.IntroductionButton
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun IntroductionScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome to\nLIFTLAB",
            color = Color(0xFF7E57C2),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 60.sp,
            lineHeight = 60.sp
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.dumbbell_simple),
            contentDescription = "dumbbell icon",
            modifier = Modifier
                .size(150.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        IntroductionButton(
            title = "Login",
            backgroundColor = Color(0xFFEEEEEE),
            textColor = Color.Black,
            onAction = onNavigateToLogin
        )

        IntroductionButton(
            title = "Sign Up",
            backgroundColor = Color(0xFF4285F4),
            onAction = onNavigateToSignUp
        )
    }
}

@Preview
@Composable
private fun IntroductionScreenPreview() {
    LiftLabTheme {
        IntroductionScreen(
            onNavigateToLogin = {},
            onNavigateToSignUp = {}
        )
    }
}