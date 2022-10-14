package com.testnavcompose.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.testnavcompose.data.currentScreens
import com.testnavcompose.nav.NavigationItem
import com.testnavcompose.ui.theme.Message
import kotlinx.coroutines.flow.MutableStateFlow


class HomeViewModel : ViewModel() {
    var listMess1:MutableList<Message> = MutableList(15) { index -> Message(index.toString(), "Message of $index") }
    //var listMess:MutableStateFlow<MutableList<Message>> = MutableStateFlow(listMess1)
    var listMess = mutableStateOf(listMess1)
    fun viewDetail(){
        currentScreens.value = NavigationItem.DetailScreen
    }
    fun onBackPressed(){
        currentScreens.value = NavigationItem.LoginScreen
    }
    /*fun updateData(message: Message){
        var list = listMess.value
        for(item in list){
            if(item.author == message.author){
                item.isExpand = !item.isExpand
            }
        }
        listMess.value = list
        listMess.value.removeAt(3)
        Log.e("homeviewmodel",listMess.value.toString())
    }*/
}