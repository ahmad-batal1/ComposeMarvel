package com.example.composemarvel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composemarvel.util.Constants.FAVORITE
import com.example.composemarvel.util.Constants.FAVORITE_ROUTE
import com.example.composemarvel.util.Constants.HOME
import com.example.composemarvel.util.Constants.HOME_ROUTE
import com.example.composemarvel.util.Constants.SEARCH
import com.example.composemarvel.util.Constants.SEARCH_ROUTE

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object HomeBottomBarScreens : BottomBarScreens(
        route = HOME_ROUTE,
        title = HOME,
        icon = Icons.Default.Home
    )

    object FavoriteBottomBarScreens : BottomBarScreens(
        route = FAVORITE_ROUTE,
        title = FAVORITE,
        icon = Icons.Default.Favorite
    )

    object SearchBottomBarScreens : BottomBarScreens(
        route = SEARCH_ROUTE,
        title = SEARCH,
        icon = Icons.Default.Search
    )
}
