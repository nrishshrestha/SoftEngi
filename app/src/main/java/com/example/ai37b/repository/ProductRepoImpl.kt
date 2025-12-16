package com.example.ai37b.repository

import android.R.attr.data
import androidx.compose.runtime.getValue
import com.example.ai37b.model.ProductModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductRepoImpl : ProductRepository{
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val ref: DatabaseReference = database.getReference("Products")

    override fun addProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        val id = ref.push().key.toString()
        model.productId = id
        ref.child(id).setValue(model).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "Product added successfully")
            } else {
                callback(false, it.exception?.message ?: "Failed to add product")
            }
        }
    }

    override fun deleteProduct(
        productId: String,
        callback: (Boolean, String) -> Unit
    ) {

    }

    override fun updateProduct(
        productId: String,
        productName: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getAllProducts(callback: (Boolean, String, List<ProductModel>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getProductByID(
        productId: String,
        callback: (Boolean, String, ProductModel?) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getProductByCategory(
        categoryId: String,
        callback: (Boolean, String, List<ProductModel>?) -> Unit
    ) {
        ref.orderByChild("categoryId").equalTo(categoryId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var allProducts = mutableListOf<ProductModel>()
                    for(data in snapshot.children) {
                        var product = data.getValue(ProductModel::class.java)
                        if(product != null) {
                            allProducts.add(product)
                        }
                    }
                    callback(true, "products fetched", allProducts)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, error.message, emptyList())
            }
        })
    }

}