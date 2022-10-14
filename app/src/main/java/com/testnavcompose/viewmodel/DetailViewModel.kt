package com.testnavcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.testnavcompose.data.currentScreens
import com.testnavcompose.nav.NavigationItem

class DetailViewModel:ViewModel() {
    fun onBackPressed(){
        currentScreens.value = NavigationItem.HomeScreen
    }
}