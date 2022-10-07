package com.testnavcompose.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.testnavcompose.viewmodel.LoginViewModel

@Composable
fun LoginUI(loginModel:LoginViewModel) {
    Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Hello bro")
            Button(onClick = { loginModel.verifyLogin()}) {
                Text(text = "Đăng nhập")

            }
    }

}