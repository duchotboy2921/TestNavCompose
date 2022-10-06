package com.testnavcompose.nav

sealed class NavigationItem(var rout:String ){
    object LoginScreen:NavigationItem("login_screen")
    object HomeScreen:NavigationItem("home_screen")
}
