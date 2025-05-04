package com.a27.liftlab.lift.presentation.home_route.generate_diet_plan.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun DietInputField(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    var value by remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = contentColor
        )
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )

            Column {
                Text(
                    text = title,
                    color = contentColor,
                    fontSize = 14.sp
                )

                OutlinedTextField(
                    value = value,
                    onValueChange = {value = it},
                    label = {Text("(Required)")}
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun DietInputFieldPreview() {
    LiftLabTheme {
        DietInputField(
            title = "Weight",
            icon = ImageVector.vectorResource(R.drawable.target)
        )
    }
}