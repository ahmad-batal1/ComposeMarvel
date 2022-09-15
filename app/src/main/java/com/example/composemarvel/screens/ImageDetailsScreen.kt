package com.example.composemarvel.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ImageDetailsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Text(text = "GGGGGGGGGGGGGGGGGGG", fontSize = 30.sp)
        Button(onClick = { navController.popBackStack() }) {}
    }
}

//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally