package com.testnavcompose.nav

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.testnavcompose.ui.theme.HomeUI
import com.testnavcompose.ui.theme.LoginUI


@Composable
fun SetupGraph(navController :NavHostController) {
    NavHost(navController = navController,
    startDestination = NavigationItem.LoginScreen.rout){
        composable(
            route = NavigationItem.LoginScreen.rout
        ){
            LoginUI()
        }
        composable(
            route = NavigationItem.HomeScreen.rout
        ){
            HomeUI()
        }
    }

}