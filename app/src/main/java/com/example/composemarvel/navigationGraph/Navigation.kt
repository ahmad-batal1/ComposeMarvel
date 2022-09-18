package com.example.composemarvel.navigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composemarvel.BottomBarScreens
import com.example.composemarvel.screens.homeScreen.HomePage
import com.example.composemarvel.screens.searchScreen.SearchPage
import com.example.composemarvel.screens.favoriteScreen.FavoritePage

@Composable
fun BaseNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.HomeBottomBarScreens.route
    ){

        composable(route = BottomBarScreens.HomeBottomBarScreens.route){
            HomePage(navController = navController)
        }

        composable(route = BottomBarScreens.FavoriteBottomBarScreens.route){
            FavoritePage()
        }

        composable(route = BottomBarScreens.SearchBottomBarScreens.route){
            SearchPage(navController = navController)
        }

        imageDetailsNavGraph(navController = navController)
    }
}