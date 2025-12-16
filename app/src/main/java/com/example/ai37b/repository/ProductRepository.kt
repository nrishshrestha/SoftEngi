package com.example.ai37b.repository

import com.example.ai37b.model.ProductModel

interface ProductRepository {
    fun addProduct(model: ProductModel,callback: (Boolean, String) -> Unit)
    fun deleteProduct(productId: String,callback: (Boolean, String) -> Unit)
    fun updateProduct(productId: String, productName: String,callback: (Boolean, String) -> Unit)
    fun getAllProducts(callback: (Boolean, String, List<ProductModel>) -> Unit)
    fun getProductByID(productId: String,callback: (Boolean, String, ProductModel?) -> Unit)
    fun getProductByCategory(
        categoryId: String,
        callback: (Boolean, String, List<ProductModel>?) -> Unit
    )
}

