package com.testnavcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.testnavcompose.nav.NavigationItem
import com.testnavcompose.nav.SetupGraph
import com.testnavcompose.nav.pushScreen
import com.testnavcompose.nav.rootnav
import com.testnavcompose.ui.theme.TestNavComposeTheme
import com.testnavcompose.viewmodel.AppViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    var viewModel = AppViewModel()
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

        GlobalScope.launch {
            for(i in 0..50){
                delay(1000)
                Log.d("state",viewModel._navigationState.value.toString())
            }
        }
    }
    @Composable
    private fun loadView() {
        rootnav = rememberNavController()
        SetupGraph(navController = rootnav)
        setCurrentScreen(viewModel = viewModel)
    }
    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    fun setCurrentScreen(viewModel: AppViewModel){
        val currentScreen =  remember {
            viewModel._navigationState
        }
        setScreen(currentScreen.value)
    }
    fun setScreen(screen:NavigationItem){
        rootnav.pushScreen(screen)
    }
}




