package com.example.cs4131_ppa.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass
import com.example.cs4131_ppa.pages.model.Product

typealias ProductPair = Pair<Product, Product>

class MainPageClass {
    companion object {
        @Composable
        fun MainPage(navController: NavController) {
            var productList: ArrayList<ProductPair> = arrayListOf(
                ProductPair(
                    Product(
                        "a", "a", "a", "a", "a", 1f, 1f
                    ),
                    Product(
                        "b", "b", "b", "b", "b", 2f, 2f
                    )
                )
            )

            TitleBarClass.TitleBar (navController) {
                LazyColumn (
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(productList) { productPair ->
                        productCard(navController, productPair)
                    }
                }
            }
        }
    }
}

@Composable
fun productCard(navController: NavController, productPair: ProductPair) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            productPair.first.name?.let { Text(it) }
        }
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxSize()
                .height(100.dp)
                .weight(1f)
        ) {
            productPair.second.name?.let { Text(it) }
        }
    }

}