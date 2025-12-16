package com.example.ai37b

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.viewmodel.ProductViewModel


@Composable
fun HomeScreen() {
    val productViewModel= remember { ProductViewModel(ProductRepoImpl()) }

    LaunchedEffect(Unit) {
        productViewModel.getAllProducts()
    }
//    val images = listOf(
//        R.drawable.face,
//        R.drawable.face,
//        R.drawable.face,
//        R.drawable.face,
//        R.drawable.face,
//        R.drawable.face,
//        R.drawable.google,
//        R.drawable.google,
//        R.drawable.google,
//        R.drawable.google,
//        R.drawable.google
//
//
//    )
//    val names = listOf(
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image",
//        "Test Image"
//    )
//    LazyColumn (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        item {
//            Text("Welcome to the app", modifier = Modifier.padding(10.dp), style = TextStyle(
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            ))
//            LazyRow {
//                items(images.size){index ->
//                    Column {
//                        Image(
//                            painter = painterResource(id = images[index]),
//                            contentDescription = null,
//                            modifier = Modifier.padding(70.dp).padding(end = 10.dp)
//                        )
//                        Text(names[index])
//                    }
//                }
//            }
//
//            Image(
//                painter = painterResource(id = R.drawable.face),
//                contentDescription = null,
//                modifier = Modifier.fillMaxWidth(),
//                contentScale = ContentScale.Crop
//            )
//
//        }
//
//        item {
//            Text("Trending products")
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(3),
//                modifier = Modifier.height(500.dp)
//            ) {
//                items(images.size){index->
//                    Image(
//                        painter = painterResource(images[index]),
//                        contentDescription = null,
//                        modifier = Modifier.size(70.dp).padding(end = 10.dp)
//                    )
//                }
//            }
//        }
//    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}