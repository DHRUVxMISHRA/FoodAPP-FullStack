package com.example.foodapp_fullstack.presentation.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.foodapp_fullstack.R

@Composable
fun HomeScreenCards(navController: NavController) {

    Card(
        onClick = {
            navController.navigate(Routes.ParticularCardScreen)
        },
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(312.dp)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val pager = rememberPagerState(
                initialPage = 0
            ) { 4 }
            CardImageRow(pagerState = pager)
             Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
             ) {
                when (pager.currentPage) {
                    0 -> PriceCard(name = "Veg-Biryani", price = "₹240")
                    1 -> PriceCard(name = "Brick Oven Pizza", price = "₹259")
                    2 -> PriceCard(name = "Spring Roll", price = "₹160")
                    3 -> PriceCard(name = "Noodles", price = "₹130")
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_bookmark_24),
                        modifier = Modifier.size(34.dp),
                        tint = Color.Black.copy(alpha = 0.6f),
                        contentDescription = "BookMark"
                    )
                }
            }
            PageCount(pagerState = pager)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 192.2.dp)
                    .height(120.dp)
            ) {
                SmallDetailCard()
                DetailCard()
            }
        }
    }
}

@Composable
fun CardImageRow(
    pagerState : PagerState
) {
    HorizontalPager(
        state = pagerState
    ) {

        when (pagerState.currentPager) {
            0 -> AsyncImage(
                model = R.drawable.veg_biryani,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null
            )

            1 -> AsyncImage(
                model = R.drawable.brick_oven_pizza,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null
            )

            2 -> AsyncImage(
                model = R.drawable.spring_roll,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null
            )

            3 -> AsyncImage(
                model = R.drawable.chowmein1,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null
            )
        }
    }
}


@Composable
fun PageCount(pagerState : PagerState) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 280.dp, top = 196.dp)
    ) {
        repeat(pagerState.pageCount){
            Spacer(
                modifier = Modifier
                    .background(
                        color = if (pagerState.currentPage == it) Color.White else Color.White.copy(
                            alpha = 0.5f
                        ),
                        shape = CircleShape
                    )
                    .size(9.dp)
            )
        }
    }
}


@Composable
fun DetailCard() {

    Card(
        modifier = Modifier.fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(bottomStart = 22.dp, bottomEnd = 22.dp)
    ) {

        
    }
    
}