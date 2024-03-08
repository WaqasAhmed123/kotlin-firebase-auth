package com.example.auth.view.signup

import androidx.compose.runtime.mutableStateOf

object SignupViewModel {
    var isCreating = mutableStateOf(false)
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")
}