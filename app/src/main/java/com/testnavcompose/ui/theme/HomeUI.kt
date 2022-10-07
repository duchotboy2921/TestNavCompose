package com.testnavcompose.ui.theme

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.testnavcompose.viewmodel.HomeViewModel

@Composable
fun HomeUI( homeViewModel: HomeViewModel){

    showMessage(homeViewModel)
}
@Composable
fun MessageCard(message:Message) {
    val isExpand = remember {
        mutableStateOf(false)
    }
    val extraPadding = if(isExpand.value) 100.dp else 0.dp
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
            onClick = { isExpand.value = !isExpand.value }) {
            Text(if (!isExpand.value) "Show more" else "Show less")
        }

    }
}
@Composable
fun showMessage( homeViewModel: HomeViewModel){
    var listMess:List<Message> = List(15) { index -> Message(index.toString(), "Message of $index") }
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn {
            items(listMess){
                    message ->
                MessageCard(message = message)
            }
        }

    }
    Column(modifier =  Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {homeViewModel.viewDetail()}) {

        }
    }

}
data class Message(val author: String, val message: String)