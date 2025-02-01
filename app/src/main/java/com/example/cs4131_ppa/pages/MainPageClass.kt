package com.example.cs4131_ppa.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass
import com.example.cs4131_ppa.pages.model.Product

typealias ProductPair = Pair<Product, Product>

var itemHeight = 300

var productList: ArrayList<ProductPair> = arrayListOf(
    ProductPair(
        Product(
            "a", "uranium", "a", "a", "a", 1f, 1f, 1.0f
        ),
        Product(
            "b", "uranium", "b", "b", "b", 2f, 2f, 4.9f
        )
    )
)

class MainPageClass {
    companion object {
        @Composable
        fun MainPage(navController: NavController) {
            TitleBarClass.TitleBar (navController) {
                LazyColumn (
                    modifier = Modifier
                        .height((productList.size * itemHeight + 20).dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(productList) { productPair ->
                        ProductCard(navController, productPair)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(navController: NavController, productPair: ProductPair) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(itemHeight.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            onClick = {navController.navigate("productDetailsPage/${productPair.first.productID}")}
        ) {
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                CardContent(productPair.first)
            }
        }
        if (productPair.second.price >= 0f) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                onClick = {navController.navigate("productDetailsPage/${productPair.second.productID}")}
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    CardContent(productPair.second)
                }
            }
        }
        else
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
        }
    }
}

@Composable
fun CardContent(product: Product)
{
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageResourceID = LocalContext.current.resources.getIdentifier(product.imagePath, "drawable", LocalContext.current.packageName)

        Image(
            painter = painterResource(imageResourceID),
            contentDescription = "${product.name} image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Text(
            text = product.name,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "$%.2f".format(product.price),
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "Rating: %.1f / 5.0".format(product.rating),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}