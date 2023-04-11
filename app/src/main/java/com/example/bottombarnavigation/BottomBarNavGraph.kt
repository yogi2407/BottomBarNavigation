package com.example.bottombarnavigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottombarnavigation.screen.HomeScreen
import com.example.bottombarnavigation.screen.ProfileScreen
import com.example.bottombarnavigation.screen.SettingScreen

private const val TAG = "Yogi"

@Composable
fun BottomBarNavGraph(navController:NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        Log.d(TAG,"BottomBarNavGraph Called ")
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