package com.testnavcompose.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.testnavcompose.viewmodel.DetailViewModel

@Composable
fun DetailUI(detailViewModel: DetailViewModel){
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(value = "oki", onValueChange = {})
        Text(text = "Detail Screen")
        BackHandler {
            detailViewModel.onBackPressed()
        }
    }
}