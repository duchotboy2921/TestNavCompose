package com.testnavcompose.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testnavcompose.data.*
import com.testnavcompose.data.currentScreens
import com.testnavcompose.data.mainContext
import com.testnavcompose.data.password
import com.testnavcompose.data.pref
import com.testnavcompose.data.prefEdit
import com.testnavcompose.nav.NavigationItem
import com.testnavcompose.nav.pushScreen
import com.testnavcompose.nav.rootnav
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginViewModel():ViewModel() {
    var uiState =  MutableStateFlow<NavigationItem>(NavigationItem.LoginScreen)
     fun verifyLogin(){
        viewModelScope.launch(){
            var pass = getPassword()            // get password from shareprefence
            Log.d("password",pass!!)
            if(password.value != ""&& password.value == pass){
                uiState.value = NavigationItem.HomeScreen
                currentScreens.value = NavigationItem.HomeScreen
                Log.d("state",uiState.value.toString())
            }else{
                Toast.makeText(mainContext,"Incorrect password!",Toast.LENGTH_LONG).show()
            }
        }
    }
    private suspend fun getPassword(): String? {
        return viewModelScope.async {
            return@async pref?.getString("password", "")
        }.await()
    }
}