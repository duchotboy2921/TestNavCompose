package com.testnavcompose.data

import android.content.Context
import android.content.SharedPreferences
import com.testnavcompose.nav.NavigationItem
import kotlinx.coroutines.flow.MutableStateFlow

internal var currentScreens: MutableStateFlow<NavigationItem> = MutableStateFlow(NavigationItem.HomeScreen)
internal var userName: MutableStateFlow<String> = MutableStateFlow("")
internal var password: MutableStateFlow<String> = MutableStateFlow("")
internal var pref: SharedPreferences? = null
internal var prefEdit: SharedPreferences.Editor? = pref?.edit()
internal var mainContext:Context? = null