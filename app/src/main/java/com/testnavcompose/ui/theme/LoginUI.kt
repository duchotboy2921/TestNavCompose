package com.testnavcompose.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.testnavcompose.data.password
import com.testnavcompose.data.userName
import com.testnavcompose.viewmodel.LoginViewModel

@Composable
fun LoginUI(loginModel:LoginViewModel) {
    Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Hello bro")
            TextField(
                label = {Text(text = "UserName")},
                value = userName.collectAsState().value,
                onValueChange = { userName.value = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        TextField(
            label = {Text(text = "Password")},
            value = password.collectAsState().value,
            onValueChange = { password.value = it})
            Button(onClick = { loginModel.verifyLogin()}) {
                Text(text = "Đăng nhập")
            }
    }

}