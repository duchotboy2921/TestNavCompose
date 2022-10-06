package com.testnavcompose.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
@Composable
fun HomeUI(){
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center){
        Text(text = "Home ne`")
    }
}