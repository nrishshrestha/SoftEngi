package com.example.ai37b.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepository

class ProductViewModel(val repository: ProductRepository) : ViewModel() {
    fun addProduct(model: ProductModel,callback: (Boolean, String) -> Unit) {
        repository.addProduct(model,callback)
    }
    fun deleteProduct(productId: String,callback: (Boolean, String) -> Unit) {
        repository.deleteProduct(productId,callback)
    }
    fun updateProduct(productId: String, productName: String,callback: (Boolean, String) -> Unit) {
        repository.updateProduct(productId,productName,callback)
    }
    fun getAllProducts(callback: (Boolean, String, List<ProductModel>) -> Unit) {
        repository.getAllProducts(callback)
    }
    fun getProductByID(productId: String,callback: (Boolean, String, ProductModel?) -> Unit) {
        repository.getProductByID(productId,callback)

    }
}