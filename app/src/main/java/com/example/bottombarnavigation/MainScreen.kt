package com.example.bottombarnavigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

private const val TAG = "Yogi"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Log.d(TAG,"MainScreen Called")
    Scaffold(bottomBar = {
        BottomBarNavigation(navController = navController)
    }) {
        BottomBarNavGraph(navController = navController)   
    }
}

@Composable
fun BottomBarNavigation(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Log.d(TAG,"navBackStackEntry Called :  $navBackStackEntry")
    Log.d(TAG,"BottomBarNavigation Called : ${currentDestination?.route} currentDestination : $currentDestination")


    BottomNavigation {
        screens.forEach { bottomBarScreen ->
            AddItem(
                screen = bottomBarScreen ,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    Log.d(TAG,"AddItem Called :  $navController")

    BottomNavigationItem(
        label = {Text(text = screen.title)},
        icon = { Icon(imageVector = screen.icon, contentDescription = "Icon Image")},
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
            Log.d(TAG,"onClick Called : ${screen.route}")
        }
    )
}