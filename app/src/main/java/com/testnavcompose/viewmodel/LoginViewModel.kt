package com.testnavcompose.viewmodel

import android.util.Log
import com.testnavcompose.nav.NavigationItem


class LoginViewModel:AppViewModel() {
    fun verifyLogin(){
        Log.d("state",_navigationState.value.toString())
        setCurrentScreen(NavigationItem.HomeScreen)
    }
}