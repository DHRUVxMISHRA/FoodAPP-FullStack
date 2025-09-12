package com.example.foodapp_fullstack.presentation.utils


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.foodapp_fullstack.R

@Composable
fun OrderPlacedDialog(
    onDismiss:()-> Unit,
    onConfirm:()-> Unit
) {

    val transition = rememberInfiniteTransition()
    val color by transition.animateColor(
        initialValue = colorResource(R.color.purple_200),//button color
        targetValue = colorResource(R.color.purple_700),//green
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Dialog(onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .fillMaxHeight(0.40f),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(10.dp)
        ) {

            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HeaderImage(modifier = Modifier.height(150.dp))

                Text(
                    text = "Order Placed !",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = color
                )
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        onDismiss()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.teal_700),//buttonColor
                        contentColor = Color.White),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(0.60f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Go Back",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Composable
fun HeaderImage(modifier: Modifier) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation))
    val progress by animateLottieCompositionAsState(composition = composition)


    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = modifier
    )
}