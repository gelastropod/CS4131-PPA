package com.example.cs4131_ppa.pages.model

import android.content.res.Resources
import com.example.cs4131_ppa.R
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.util.Locale

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

        fun returnFilteredProductList(filter: String): ArrayList<Product> {
            if (filter.isBlank())
                return productList

            val filteredProductList: ArrayList<Product> = arrayListOf()

            for (product in productList)
                if (product.name.lowercase(Locale.ROOT).contains(filter.lowercase(Locale.ROOT).toRegex()))
                    filteredProductList.add(product)

            return filteredProductList
        }

        fun returnPairProducts(filteredProductList: ArrayList<Product>): ArrayList<ProductPair> {
            val productPairList: ArrayList<ProductPair> = arrayListOf()

            for (i in 0..<(filteredProductList.size - 1) step 2) {
                val firstProduct = filteredProductList[i]
                val secondProduct = filteredProductList[i + 1]
                val productPair = ProductPair(firstProduct, secondProduct)
                productPairList.add(productPair)
            }

            if (filteredProductList.size % 2 == 1) {
                val firstProduct = filteredProductList[filteredProductList.size - 1]
                val secondProduct = dummyProduct()
                val productPair = ProductPair(firstProduct, secondProduct)
                productPairList.add(productPair)
            }

            return productPairList
        }

        fun getProduct(ID: Int) : Product {
            return productList.get(ID)
        }
    }
}