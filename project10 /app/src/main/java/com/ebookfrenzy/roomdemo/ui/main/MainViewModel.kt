package com.ebookfrenzy.roomdemo.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.roomdemo.Product
import com.ebookfrenzy.roomdemo.ProductRepository
import android.util.Log

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository = ProductRepository(application)
    private var allProducts: LiveData<List<Product>>?
    private val searchResults: MutableLiveData<List<Product>>

    private val TAG = "StateTAG"

    init {
        allProducts = repository.allProducts
        searchResults = repository.searchResults
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun findProduct(name: String) {
        repository.findProduct(name)
    }

    fun deleteProduct(id: Int) {
        Log.i(TAG, "deleteProduct")
        repository.deleteProduct(id)
    }

    fun getSearchResults(): MutableLiveData<List<Product>> {
        return searchResults
    }

    fun getAllProducts(): LiveData<List<Product>>? {
        return allProducts
    }
    fun getAllProductsAsc(){
        Log.i(TAG, "getAllProductsAsc")
       allProducts = repository.allProductsAsc
    }
    fun getAllProductsDesc(){
        Log.i(TAG, "getAllProductsDesc")
        allProducts =   repository.allProductsDesc
    }
}