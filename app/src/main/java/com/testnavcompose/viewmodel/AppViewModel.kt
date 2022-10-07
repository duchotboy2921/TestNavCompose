package com.testnavcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.testnavcompose.nav.NavigationItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class AppViewModel: ViewModel() {
     val _navigationState = MutableStateFlow<NavigationItem>(NavigationItem.LoginScreen);
    //al navigateState: StateFlow<NavigationItem> get() = _navigationState
    fun setCurrentScreen(screen:NavigationItem){
        _navigationState.value = screen;
    }
}