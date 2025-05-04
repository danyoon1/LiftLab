package com.a27.liftlab.lift.presentation.home_route.diet_plan.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.ui.theme.LiftLabTheme

@Composable
fun ViewDietPlanButton(
    title: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(10.dp)
            .width(250.dp)
            .height(70.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4285F4),
            contentColor = Color.White
            // Here in two days when we realize "Damn... this really is alot"
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun ViewDietPlanButtonPreview() {
    LiftLabTheme {
        ViewDietPlanButton(
            title = "Generate New Diet",
        )
    }
}