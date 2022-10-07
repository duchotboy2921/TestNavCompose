package com.testnavcompose.nav
import androidx.navigation.NavHostController
lateinit var rootnav:NavHostController
internal fun NavHostController.pushScreen(screen:NavigationItem){
    navigate(screen.rout){
        launchSingleTop = true
    }
}
internal fun NavHostController.popUpToFirstAndNavigate(screen: NavigationItem){
    popBackStack(graph.startDestinationId,false)
    navigate(screen.rout){
        launchSingleTop = true
    }
}