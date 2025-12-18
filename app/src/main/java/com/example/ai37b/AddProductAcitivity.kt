package com.example.ai37b

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.viewmodel.ProductViewModel

class AddProductAcitivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AddProductBody()
        }
    }
}

@Composable
fun AddProductBody() {
    val keyBoardController = LocalSoftwareKeyboardController.current
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productCategory by remember { mutableStateOf("") }
    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }
    val context = LocalContext.current
    val activity = context as Activity

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Text("Add Product",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                color = Color(0xFF3460FB),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = productName,
                onValueChange = { data ->
                    productName = data
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("Enter product name")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFDFD),
                    unfocusedContainerColor = Color(0xFFDFE0EB),
                    focusedIndicatorColor = Color(0xFF596096),
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = productCategory,
                onValueChange = { data ->
                    productCategory = data
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("Enter product category")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFDFD),
                    unfocusedContainerColor = Color(0xFFDFE0EB),
                    focusedIndicatorColor = Color(0xFF596096),
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = productDescription,
                onValueChange = { data ->
                    productDescription = data
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("Enter product discription")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFDFD),
                    unfocusedContainerColor = Color(0xFFDFE0EB),
                    focusedIndicatorColor = Color(0xFF596096),
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = productPrice,
                onValueChange = { data ->
                    productPrice = data
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("Enter product price")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFDFD),
                    unfocusedContainerColor = Color(0xFFDFE0EB),
                    focusedIndicatorColor = Color(0xFF596096),
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = productQuantity,
                onValueChange = { data ->
                    productQuantity = data
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text("Enter product Quantity")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFDFD),
                    unfocusedContainerColor = Color(0xFFDFE0EB),
                    focusedIndicatorColor = Color(0xFF596096),
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(onClick = {
                keyBoardController?.hide()
                if (productName.isNotBlank() && productQuantity.isNotBlank() && productDescription.isNotBlank() && productPrice.isNotBlank()) {
                    val product = ProductModel(
                        productId = "",
                        name = productName,
                        price = productPrice.toDouble(),
                        description = productDescription,
                        categoryId = productCategory
                    )
                    productViewModel.addProduct(product) { success, message ->
                        if (success) {
                            Toast.makeText(context, "Product added successfully", Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, DashboardActivity::class.java)
                            context.startActivity(intent)
                            activity.finish()
                        } else {
                            Toast.makeText(context, message ?: "Failed to add product", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .height(60.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 15.dp
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Add")
            }
        }
    }
}

@Composable
@Preview
fun AddProductPreview() {
    AddProductBody()
}
