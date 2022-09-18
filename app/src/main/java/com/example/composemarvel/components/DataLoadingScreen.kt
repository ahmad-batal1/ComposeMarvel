package com.example.composemarvel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.composemarvel.R
import com.example.composemarvel.ui.theme.PrimaryColor
import com.example.composemarvel.util.ScreenState

@Composable
fun DataLoadingScreen(
    screenState: ScreenState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EmptyListLottieAnimation(screenState)
    }
}

@Composable
private fun EmptyListLottieAnimation(
    screenState: ScreenState
) {
    val composition by rememberLottieComposition(lottieAnimationDependingOnScreenState(screenState))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        restartOnPlay = true,
        modifier = Modifier.width(150.dp)
            .height(150.dp)
    )
}

private fun lottieAnimationDependingOnScreenState(
    screenState: ScreenState
): LottieCompositionSpec.RawRes {
    return when(screenState){
        ScreenState.Home-> LottieCompositionSpec.RawRes(R.raw.loading_list)
        ScreenState.Search-> LottieCompositionSpec.RawRes(R.raw.search_movie)
    }

}

@Composable
@Preview
private fun LottieAnimationPreview() {
    DataLoadingScreen(ScreenState.Search)
}