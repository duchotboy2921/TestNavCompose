package com.testnavcompose.ui.theme

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.testnavcompose.data.userName
import com.testnavcompose.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeUI( homeViewModel: HomeViewModel){

//    showMessage(homeViewModel)
    homeViewModel.listMess.let {list ->
        Log.e("homeui","Reload compose${list.value}")
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = userName.collectAsState().value,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
            Button(onClick = {homeViewModel.viewDetail()},
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Detail")
            }
            LazyColumn {
                items(list.value){
                        message ->
                    MessageCard(message = message,homeViewModel)
                }
            }
        }
    }
}
@Composable
fun MessageCard(message:Message, homeViewModel: HomeViewModel) {
    val extraPadding = if(message.isExpand.value) 100.dp else 0.dp
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 2.dp)) {
        Image(painter = painterResource(id = com.testnavcompose.R.drawable.oki),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(3.dp, MaterialTheme.colors.secondaryVariant, CircleShape))

        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier
            .weight(1f)
            .padding(bottom = extraPadding)) {
            Text(text = message.author, color = MaterialTheme.colors.primaryVariant)
            Text(text = message.message)
        }
        OutlinedButton(
            onClick = {
                message.isExpand.value = !message.isExpand.value
                //homeViewModel.updateData(message)
            }) {
            Text(if (!message.isExpand.value) "Show more" else "Show less"
            )
        }

    }
}
@Composable
fun showMessage( homeViewModel: HomeViewModel){
        homeViewModel.listMess.value.let {list ->
            Log.e("homeui","Reload compose$list")
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = userName.collectAsState().value,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                Button(onClick = {homeViewModel.viewDetail()},
                    modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Detail")
                }
                LazyColumn {
                    items(list){
                            message ->
                        MessageCard(message = message,homeViewModel)
                    }
                }
        }
    }
    BackHandler {
        homeViewModel.onBackPressed()
    }
}
data class Message(val author: String, val message: String, var isExpand: MutableState<Boolean> = mutableStateOf(false))