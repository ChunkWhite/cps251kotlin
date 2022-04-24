package com.ebookfrenzy.roomdemo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class Product {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "productId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String? = null
    var quantity: String = ""

    constructor() {}

    constructor(id: Int, productname: String, quantity: String) {
        this.productName = productname
        this.quantity = quantity
    }
    constructor(productname: String, quantity: String) {
        this.productName = productname
        this.quantity = quantity
    }
}