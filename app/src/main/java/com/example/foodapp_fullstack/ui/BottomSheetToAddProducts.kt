package com.example.foodapp_fullstack.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp_fullstack.R
import com.example.foodapp_fullstack.presentation.navigation.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetToAddProducts(
    onDismiss: () -> Unit,
    navController: NavController
) {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var text by remember { mutableStateOf("") }
    var count by remember { mutableIntStateOf(1) }

    ModalBottomSheet(
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding(),
        sheetState = sheetState,
        dragHandle = {},
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        onDismissRequest = { onDismiss() }
    ) {

        Scaffold(
            bottomBar = {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    //counter with +/- buttons
                    Row(
                        modifier = Modifier
                            .border(
                                border = 1.dp,
                                color = Color.Red, // color = colorResource(R.color.addButtonRed)
                                shape = RoundedCornerShape(4.dp)
                            )
                            .height(40.dp)
                            .background(colorResource(R.color.purple_200)),//colorResource(R.color.lightPink)
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //Minus Button
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .fillMaxHeight()
                                .clickable { count-- },
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "-",
                                fontSize = 20.sp,
                                color = Color.Red // color = colorResource(R.color.addButtonRed)
                            )
                        }

                        //Counter value
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = count.toString(),
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }

                        //Plus button
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .fillMaxHeight()
                                .clickable { count++ },
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "+",
                                fontSize = 20.sp,
                                color = Color.Red // color = colorResource(R.color.addButtonRed)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))


                    //Add item button
                    Button(
                        onClick = {
                            navController.navigate(Routes.FinalCheckOutScreen)
                        },
                        modifier = Modifier
                            .height(40.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200)),//buttonColor
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Add item ₹249",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        ) {
            it
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .background(color = Color.Transparent)
            ) {
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {  }
                }
            }
        }
    }
}