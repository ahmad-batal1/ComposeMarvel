package com.example.composemarvel.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composemarvel.BottomBarScreens
import com.example.composemarvel.ui.theme.PrimaryColor
import com.example.composemarvel.ui.theme.SecondaryTextColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationBottom(navController: NavHostController) {

    val bottomBarScreensItems = listOf(
        BottomBarScreens.HomeBottomBarScreens,
        BottomBarScreens.SearchBottomBarScreens,
        BottomBarScreens.FavoriteBottomBarScreens
    )

    BottomNavigation(
        navController,
        bottomBarScreensItems
    )

}

@Composable
private fun BottomNavigation(
    rememberNavController: NavHostController,
    listOfScreen: List<BottomBarScreens>
) {
    val navBackStackEntry by rememberNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = listOfScreen.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            modifier = Modifier.clip(
                RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ),
            backgroundColor = SecondaryTextColor,
            contentColor = PrimaryColor
        ) {
            listOfScreen.forEach { screenPage ->
                AddItem(
                    screen = screenPage,
                    currentDestination = currentDestination,
                    navController = rememberNavController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            onClickNavigationBottom(navController,screen)
        }
    )
}

fun onClickNavigationBottom(rememberNavController: NavController, screenPage: BottomBarScreens) {
    rememberNavController.navigate(screenPage.route) {
        popUpTo(rememberNavController.graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}