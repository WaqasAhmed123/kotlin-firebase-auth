package com.example.auth.view.search

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.auth.view.home.HomeViewModel
import textStyle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchViewScreen(navController: NavController) {
    Scaffold(modifier = Modifier.padding(16.dp),
        topBar = {
        Row {
//            IconButton(onClick = { /* do something */ }) {
//                Icon(
//                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                    contentDescription = "Localized description"
//                )
//                Spacer(modifier = Modifier.width(15.dp))
//            }
            OutlinedTextField(
                leadingIcon = {
                    IconButton(onClick = {
                        if (SearchViewModel.searchProduct.value.isNotEmpty()) {
                            SearchViewModel.visibleSearchResult.value = true


                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                trailingIcon = {
//                    IconButton(onClick = {
//
//                    }) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clickable(onClick = {})
                            .clip(CircleShape)
                            .background(Color.Black)
                            .clickable {
                                SearchViewModel.searchProduct.value = ""
                                SearchViewModel.visibleSearchResult.value = false
                            }, contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color.White
                        )
                    }
//                    }
                },
                placeholder = {
                    Text(
                        text = "Search here",
                        style = textStyle(textColor = Color.Gray)["bodySmall"]!!
                    )
                },
                value = SearchViewModel.searchProduct.value,
                textStyle = textStyle(textColor = Color.Gray)["bodySmall"]!!,
                onValueChange = {
                    SearchViewModel.searchProduct.value = it
                },
                modifier = Modifier
                    .border(
                        BorderStroke(
                            width = 2.dp, color = MaterialTheme.colorScheme.secondary
                        ), shape = RoundedCornerShape(50)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = (MaterialTheme.colorScheme.secondary),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
            )
        }
    }) {


        Column(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            if (SearchViewModel.visibleSearchResult.value) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    //            Text(text = category, style = textStyle()["titleLarge"]!!)
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color(0xFF817F7F))) {
                                append("Results for ")
                            }
                            withStyle(style = SpanStyle(color = Color.Black)) {
                                append("\"${SearchViewModel.searchProduct.value}\"")
                            }


                        }, style = textStyle()["titleMedium"]!!
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = { }) {
                        Text(
                            text = "${SearchViewModel.totalResults.value} Results Found",
                            style = textStyle(textColor = MaterialTheme.colorScheme.primary)["bodySmall"]!!
                        )

                    }
                }

            }
        }
    }
}
