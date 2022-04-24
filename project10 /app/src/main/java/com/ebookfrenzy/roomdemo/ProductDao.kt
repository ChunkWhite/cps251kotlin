package com.ebookfrenzy.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(product: Product)

    @Query("SELECT * FROM products WHERE productName LIKE '%' || :name || '%'")
    fun findProduct(name: String): List<Product>

    @Query("DELETE FROM products WHERE productId = :id")
    fun deleteProduct(id: Int)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM products ORDER BY productName ASC")
    fun getAllProductsAsc(): LiveData<List<Product>>

    @Query("SELECT * FROM products ORDER BY productName DESC")
    fun getAllProductsDesc(): LiveData<List<Product>>
}