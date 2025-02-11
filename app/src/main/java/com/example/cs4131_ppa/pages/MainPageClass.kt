package com.example.cs4131_ppa.pages

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.components.TitleBarClass
import com.example.cs4131_ppa.model.Product
import com.example.cs4131_ppa.model.ProductPair

var itemHeight = 350

class MainPageClass {
    companion object {
        private lateinit var productList: ArrayList<ProductPair>

        @Composable
        fun MainPage(navController: NavController, resources: Resources) {
            val filterState = remember { mutableStateOf("") }

            Product.loadProducts(resources)
            productList = Product.returnPairProducts(Product.returnFilteredProductList(filterState.value))

            TitleBarClass.TitleBar (navController) { sizeState ->
                LazyColumn (
                    modifier = Modifier
                        .size(with (LocalDensity.current) {
                            DpSize(sizeState.value.width.toDp(), sizeState.value.height.toDp())
                        }),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        TextField(
                            value = filterState.value,
                            onValueChange = { newText -> filterState.value = newText },
                            placeholder = {
                                Row (
                                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.tag_search_outline),
                                        contentDescription = "Search"
                                    )
                                    Text("Search for products...")
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            trailingIcon = {
                                IconButton(onClick = {
                                    filterState.value = ""
                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.close),
                                        contentDescription = "Clear Filter"
                                    )
                                }
                            }
                        )
                    }
                    items(productList) { productPair ->
                        ProductCard(navController, productPair, false)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(navController: NavController, productPair: ProductPair, fromCart: Boolean) {
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
            onClick = {navController.navigate("productDetailsPage/${productPair.first.productID}/${if (fromCart) "1" else "0"}")}
        ) {
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                CardContent(productPair.first)
            }
        }
        if (productPair.second.productID >= 0) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                onClick = {navController.navigate("productDetailsPage/${productPair.second.productID}/${if (fromCart) "1" else "0"}")}
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
                .height(100.dp)
        )
        HorizontalDivider()
        Text(
            text = "$%.2f".format(product.price),
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "%.1f / 5.0★".format(product.rating),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}