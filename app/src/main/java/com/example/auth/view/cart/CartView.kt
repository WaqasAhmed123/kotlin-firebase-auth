package com.example.auth.view.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.auth.composables.CartProductBox
import com.example.auth.composables.ItemTitleWithImage
import com.example.auth.view.home.HomeViewModel
import textStyle

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartView(navController: NavController) {
    Scaffold(modifier = Modifier.padding(horizontal = 16.dp), topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Cart", style = textStyle()["titleLarge"]!!
                )
            },
        )

    }) {
        LazyColumn(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            itemsIndexed(CartViewModel.cartProducts) {index, pairs ->
                CartProductBox(
                    productName = pairs.firstOrNull { it.first == "productName" }?.second as? String
                        ?: "",
//                    brand = pairs.firstOrNull { it.first == "brand" }?.second as? String ?: "",
                    quantity = pairs.firstOrNull { it.first == "quantity" }?.second as? Int ?: 0,
                    price = pairs.firstOrNull { it.first == "price" }?.second as? String ?: "",
                    onAddProductClick ={CartViewModel.incrementQuantity(productIndex = index)
                                       },
                    onDeleteProductClick ={CartViewModel.decrementQuantity(productIndex = index)},
                    onProductDelete ={CartViewModel.deleteProduct(productIndex = index)
                                     println("deleted")
                                     },
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
