package com.example.composemarvel.navigationGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composemarvel.util.Constants.DETAILS_ROUTE
import com.example.composemarvel.util.Constants.MAIN_MAIN_SCREEN
import com.example.composemarvel.screens.ImageDetailsScreen

fun NavGraphBuilder.imageDetailsNavGraph(navController: NavHostController){
    navigation(
        route = DETAILS_ROUTE,
        startDestination = DetailsScreen.Details.route
    ){
        composable(route =  DetailsScreen.Details.route){
            ImageDetailsScreen(navController)
        }
    }
}

sealed class DetailsScreen(val route:String){
    object Details: DetailsScreen(route = MAIN_MAIN_SCREEN)
}