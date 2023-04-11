package com.example.bottombarnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottombarnavigation.screen.HomeScreen
import com.example.bottombarnavigation.screen.ProfileScreen
import com.example.bottombarnavigation.screen.SettingScreen

@Composable
fun BottomBarNavGraph(navController:NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingScreen()
        }
    }
}