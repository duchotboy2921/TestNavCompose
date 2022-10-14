package com.testnavcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.testnavcompose.data.currentScreens
import com.testnavcompose.data.mainContext
import com.testnavcompose.data.pref
import com.testnavcompose.nav.NavigationItem
import com.testnavcompose.nav.SetupGraph
import com.testnavcompose.nav.pushScreen
import com.testnavcompose.nav.rootnav
import com.testnavcompose.ui.theme.TestNavComposeTheme
import com.testnavcompose.viewmodel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestNavComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loadView()
                }
            }
        }
        pref = getSharedPreferences("CheckAuth", MODE_PRIVATE)      // init data
        //prefEdit?.putString("password","minhduc")
        //prefEdit?.commit()
        pref?.edit()?.putString("password","minhduc")?.commit()
        mainContext = this

        GlobalScope.launch {
            for(i in 0..20){
                delay(1000)
                Log.d("state", currentScreens.value.toString())
            }
        }
    }
    @Composable
    private fun loadView() {
        rootnav = rememberNavController()
        SetupGraph(navController = rootnav)
        setCurrentScreen()
    }
    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    fun setCurrentScreen(){
        val currentSC by currentScreens.collectAsState()
        setScreen(currentSC)
    }
    fun setScreen(screen:NavigationItem){
        rootnav.pushScreen(screen)
    }

}




