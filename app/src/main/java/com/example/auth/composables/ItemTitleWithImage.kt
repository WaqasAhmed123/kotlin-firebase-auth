package com.example.auth.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.auth.R
import textStyle


@SuppressLint("UnrememberedMutableState")
@Composable
fun ItemTitleWithImage(
    onItemClick: () -> Unit,
    onAddItemClick: () -> Unit,
    itemName: String,
    itemPrice: String,
    isAddButton: Boolean = false
) {
    var isFavourite = mutableStateOf(false)
    Box(modifier = Modifier
        .width(126.dp)
        .height(143.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.secondary)
        .clickable { onItemClick() }
//            .padding(8.dp) // Add padding to control space around the Column
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.watch),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,

                    modifier = Modifier
                        .height(99.dp)
//                        .fillMaxSize()
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp)) // Clip the image to a circular shape
                )
                IconButton(
                    onClick = {
                        isFavourite.value = !isFavourite.value
                    }, modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 2.dp, end = 2.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Transparent),
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
                        tint = if (isFavourite.value) {
//                            Color.Red
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.White
                        }
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)
            ) {
//            Row ( modifier = Modifier.padding(horizontal = 8.dp)){
                Column {
                    Text(
                        text = itemName,
                        style = textStyle()["titleMedium"]!!,
//                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)

//                modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = itemPrice,
                        style = textStyle(textColor = MaterialTheme.colorScheme.primary)["bodySmall"]!!,
//                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                if (isAddButton) {
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        contentAlignment = Alignment.Center, modifier = Modifier
//                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                            .size(20.dp)
                            .clickable(onClick = onAddItemClick)

                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
            // Placeholder for image

//            IconButton(
//                onClick = { /* Your action here */ },
//                modifier = Modifier.padding(end = 8.dp, bottom = 8.dp) // Adjust padding as needed
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Favorite,
//                    contentDescription = "Favorite",
//                    tint = Color.Black
//                )
//            }
        }
    }
}
