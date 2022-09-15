package com.example.composemarvel.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun HomePage(navController: NavHostController) {
    val homeViewModel : HomeScreenViewModel
    val lifecycleOwner = LocalLifecycleOwner.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "GG", fontSize = 30.sp)
        Button(onClick = {}) {}
    }
}
//            navController.navigate(DETAILS_ROUTE)
