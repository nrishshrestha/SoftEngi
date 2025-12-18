package com.example.ai37b


import android.app.Activity
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.viewmodel.ProductViewModel


@Composable
fun HomeScreen() {
    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }
    val context = LocalContext.current
    val activity = LocalContext.current
    val products = productViewModel.allProducts.observeAsState(initial = emptyList())

    var showAlertDialog by remember { mutableStateOf(false) }
    var editedName by remember { mutableStateOf("") }
    var editedDescription by remember { mutableStateOf("") }
    var editedPrice by remember { mutableStateOf("") }
    var editedQuantity by remember { mutableStateOf("") }
    var product by remember {mutableStateOf<ProductModel?>(null)}


    LaunchedEffect(Unit) {
        productViewModel.getAllProduct()
    }


    if (showAlertDialog) {
        AlertDialog(
            onDismissRequest = { showAlertDialog = false},
            title = {
                Text("Edit Product")
            },
            text = {
                Column {
                    OutlinedTextField(
                            value = editedName,
                    onValueChange = { editedName = it },
                    label = { Text("Product Name") },
                    modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = editedPrice,
                        onValueChange = { editedPrice = it },
                        label = { Text("Product Price") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = editedQuantity,
                        onValueChange = { editedQuantity = it },
                        label = { Text("Product Quantity") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = editedDescription,
                        onValueChange = { editedDescription = it },
                        label = { Text("Product Description") },
                        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)

                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                }) {
                    Text("Update")
                }
            },
            dismissButton = {
                Button(onClick = {
                    showAlertDialog = false
                }) {
                    Text("Cancel")
                }
            }
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(products.value!!.size) { index ->
            var data = products.value!![index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.weight(1f).padding(20.dp)
                    ) {
                        Text(data.name)
                        Text(data.price.toString())
                        Text(data.description)

                    }
                    Column() {
                        IconButton(onClick = {
                            editedName = data.name
                            editedDescription = data.description
                            editedPrice = data.price.toString()
                            editedQuantity = data.price.toString()
                            product = data
                            showAlertDialog = true
                        }) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        }
                        IconButton(onClick = {
                            productViewModel.deleteProduct(data.productId) { success, message ->
                                if (success) {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

                                }
                            }
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = null, tint = Color.Red)
                        }
                    }
                }
            }
        }

    }
}
//        images = listOf(
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

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}