package com.example.auth.view.search

import androidx.compose.runtime.mutableStateOf


object SearchViewModel {
    var searchProduct = mutableStateOf("")
    var visibleSearchResult = mutableStateOf(false)
    var totalResults = mutableStateOf<Int>(0)

}