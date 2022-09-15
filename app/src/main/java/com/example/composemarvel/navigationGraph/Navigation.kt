package com.example.composemarvel.navigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composemarvel.BottomBarScreens
import com.example.composemarvel.screens.homeScreen.HomePage
import com.example.composemarvel.screens.SearchPage
import com.example.composemarvel.screens.CategoriesPage

@Composable
fun BaseNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.HomeBottomBarScreens.route
    ){

        composable(route = BottomBarScreens.HomeBottomBarScreens.route){
            HomePage(navController)
        }

        composable(route = BottomBarScreens.CategoriesBottomBarScreens.route){
            CategoriesPage()
        }

        composable(route = BottomBarScreens.SearchBottomBarScreens.route){
            SearchPage()
        }

        imageDetailsNavGraph(navController = navController)
    }
}