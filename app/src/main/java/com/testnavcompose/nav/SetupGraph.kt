package com.testnavcompose.nav

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.testnavcompose.data.currentScreens
import com.testnavcompose.ui.theme.DetailUI
import com.testnavcompose.ui.theme.HomeUI
import com.testnavcompose.ui.theme.LoginUI
import com.testnavcompose.viewmodel.DetailViewModel
import com.testnavcompose.viewmodel.HomeViewModel
import com.testnavcompose.viewmodel.LoginViewModel


@Composable
fun SetupGraph(navController :NavHostController) {
    NavHost(navController = navController,
            startDestination = NavigationItem.HomeScreen.rout){
        composable(
            route = NavigationItem.LoginScreen.rout
        ){
            //currentScreens.value = NavigationItem.LoginScreen
            LoginUI(LoginViewModel())

        }
        composable(
            route = NavigationItem.HomeScreen.rout
        ){
            //currentScreens.value = NavigationItem.HomeScreen
            HomeUI(HomeViewModel())
        }
        composable(
            route = NavigationItem.DetailScreen.rout
        ){
            //currentScreens.value = NavigationItem.DetailScreen
            DetailUI(DetailViewModel())
        }
    }

}