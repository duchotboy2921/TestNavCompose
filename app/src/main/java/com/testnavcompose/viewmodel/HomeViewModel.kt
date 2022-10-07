package com.testnavcompose.viewmodel

import com.testnavcompose.nav.NavigationItem


class HomeViewModel : AppViewModel() {
    fun viewDetail(){
        //rootnav.popUpToFirstAndNavigate(NavigationItem.DetailScreen)
        setCurrentScreen(NavigationItem.DetailScreen)

    }
}