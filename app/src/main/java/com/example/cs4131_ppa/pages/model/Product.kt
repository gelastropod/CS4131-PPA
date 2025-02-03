package com.example.cs4131_ppa.pages.model

import android.content.res.Resources
import com.example.cs4131_ppa.R
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

typealias ProductPair = Pair<Product, Product>

@Serializable
class Product(
    var name: String,
    var imagePath: String,
    var description: String,
    var category: String,
    var brand: String,
    var size: String,
    var price: Float,
    var rating: Float,
    var productID: Int
) {
    companion object {
        private var loadedProducts: Boolean = false
        private var productList: ArrayList<Product> = arrayListOf()

        private fun dummyProduct(): Product {
            return Product(
                "", "", "", "", "", "", 0f, 0f, -1
            )
        }

        fun loadProducts(resources: Resources) {
            if (!loadedProducts) {
                val fileContent = resources.openRawResource(R.raw.product_data)
                    .bufferedReader().use { it.readText() }

                productList = Json.decodeFromString(fileContent)

                loadedProducts = true
            }
        }

        fun returnPairProducts(): ArrayList<ProductPair> {
            val productPairList: ArrayList<ProductPair> = arrayListOf()

            for (i in 0..<(productList.size - 1) step 2) {
                val firstProduct = productList[i]
                val secondProduct = productList[i + 1]
                val productPair = ProductPair(firstProduct, secondProduct)
                productPairList.add(productPair)
            }

            if (productList.size % 2 == 1) {
                val firstProduct = productList[productList.size - 1]
                val secondProduct = dummyProduct()
                val productPair = ProductPair(firstProduct, secondProduct)
                productPairList.add(productPair)
            }

            return productPairList
        }
    }
}