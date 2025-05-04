package com.a27.liftlab.lift.presentation.home_route.diet_plan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a27.liftlab.lift.domain.DietPlan
import com.a27.liftlab.ui.theme.LiftLabTheme
import com.example.liftlab.R

@Composable
fun DietPlanItem(
    dietPlan: DietPlan,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
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
        Column {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Based on:",
                        color = contentColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black
                    )

                    Text(
                        text = "Weight: ${dietPlan.bodyWeight} lbs"
                    )

                    Text(
                        text = "Goal: ${dietPlan.goal}"
                    )

                    Text(
                        text = "Desired Weight: ${dietPlan.desiredWeight} lbs"
                    )

                    Text(
                        text = "Time Constraint: ${dietPlan.timeConstraint}"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Diet Recommendations",
                        fontWeight = FontWeight.Black,
                        fontSize = 20.sp
                    )
                    
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.kcal),
                            contentDescription = "kcal",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(12.dp)
                        )

                        Text(
                            text = "${dietPlan.calPerDay} kcal per day"
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.protein),
                            contentDescription = "kcal",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(12.dp)
                        )

                        Text(
                            text = "${dietPlan.proteinPerDay} grams of protein per day"
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.carbohydrate),
                            contentDescription = "kcal",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(12.dp)
                        )

                        Text(
                            text = "${dietPlan.carbPerDay} grams of carbohydrates per day"
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.fat),
                            contentDescription = "kcal",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(12.dp)
                        )

                        Text(
                            text = "${dietPlan.fatPerDay} grams of fat per day"
                        )
                    }

                    dietPlan.otherNotes.forEach { note ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.notes),
                                contentDescription = "other notes",
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(12.dp)
                            )

                            Text(
                                text = note
                            )
                        }
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun DietPlanItemPreview() {
    LiftLabTheme {
        DietPlanItem(
            dietPlan = DietPlan(
                name = "Get strong plan",
                bodyWeight = 150,
                goal = "Get big",
                desiredWeight = 200,
                timeConstraint = "3 Months",
                calPerDay = 3000,
                proteinPerDay = 200,
                carbPerDay = 350,
                fatPerDay = 100,
                otherNotes = listOf("Eat fruits", "Eat vegetables")
            )
        )
    }
}