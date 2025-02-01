package com.example.cs4131_ppa.pages.model

class Product(
    var name: String,
    var imagePath: String,
    var description: String,
    var category: String,
    var brand: String,
    var size: Float,
    var price: Float,
    var rating: Float
) {
    companion object {
        var numProductTypes: Int = 0
        var productList: ArrayList<Product> = arrayListOf()
    }
    var productID: Int

    init {
        productID = numProductTypes
        productList.add(this)
        numProductTypes++
    }
}