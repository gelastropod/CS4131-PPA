package com.example.cs4131_ppa.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.pages.components.TitleBarClass
import com.example.cs4131_ppa.pages.model.Product

class ProductDetailsPageClass {
    companion object {
        @Composable
        fun ProductDetailsPage(navController: NavController, productID: Int) {
            var product = Product.getProduct(productID)
            val imageResourceID = LocalContext.current.resources.getIdentifier(product.imagePath, "drawable", LocalContext.current.packageName)
            TitleBarClass.TitleBar (navController) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(imageResourceID),
                        contentDescription = "Item ID: $productID",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                        //horizontalArrangement = Alignment.Start
                    ) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp) //Container for categories

                        ) {
                            Text(
                                text = product.category,
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                        }
                    }
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "$%.2f".format(product.price),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )
                    HorizontalDivider()
                    Text(
                        text = product.description,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )
                    HorizontalDivider()

                    Button(
                        onClick = {
                            Product.buyItem(productID)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Add to cart")
                        Box(
                            modifier = Modifier.width(3.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.cart_arrow_down),
                            contentDescription = "Checkout"
                        )
                    }
                    Button(
                        onClick = {
                            Product.removeItem(productID)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Remove from cart")
                        Box(
                            modifier = Modifier.width(3.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.cart_arrow_up),
                            contentDescription = "Remove product :c"
                        )
                    }

                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(
                                text = "Product details",
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Left,
                                modifier = Modifier.fillMaxWidth()
                            )
                            HorizontalDivider(
                                modifier = Modifier.padding(2.dp)
                            )
                            Text(
                                text = "Brand: " + product.brand,
                                textAlign = TextAlign.Left,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(
                                text = "Size: " + product.size, //TODO:
                                textAlign = TextAlign.Left,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    HorizontalDivider()
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {navController.navigate("homePage")}
                    ) {
                        Text("Back")
                    }
                }
            }
        }
    }
}