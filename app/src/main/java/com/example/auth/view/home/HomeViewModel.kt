package com.example.auth.view.home

import androidx.compose.runtime.mutableStateOf

object HomeViewModel {
    var isSigningOut= mutableStateOf(false)
    var userName= mutableStateOf("Waqas")
    var search= mutableStateOf("")

}