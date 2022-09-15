package com.example.composemarvel.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composemarvel.navigationGraph.BaseNavGraph
import com.example.composemarvel.widgets.NavigationBottom


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BaseHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { NavigationBottom(navController = navController) }
    ) {
        BaseNavGraph(navController)
    }
}