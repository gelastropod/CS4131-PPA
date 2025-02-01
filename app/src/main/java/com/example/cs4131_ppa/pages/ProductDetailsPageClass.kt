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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.pages.components.TitleBarClass

class ProductDetailsPageClass {
    companion object {
        @Composable
        fun ProductDetailsPage(navController: NavController, productID: Int) {
            TitleBarClass.TitleBar (navController) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.uranium), //TODO: change to correct resource
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
                                text = "Elements", //TODO: implement programmatic category
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                        }
                    }
                    Text(
                        text = "Uranium-235", //TODO: implement programmatic name
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "$150.00",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )
                    HorizontalDivider()
                    Text(
                        text = "Highest grade enriched uranium. Perfect for hobbyist nuclear projects!", //TODO: implement programmatic descriptions
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth()
                    )
                    HorizontalDivider()

                    Button(
                        onClick = { navController.navigate("paymentPage/$productID") },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Pay")
                        Box(
                            modifier = Modifier.width(3.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.credit_card_outline),
                            contentDescription = "Checkout"
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
                                text = "Brand: " + "Gelastropod Nuclear Products Inc.", //TODO: implement programmatic brand
                                textAlign = TextAlign.Left,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(
                                text = "Size: " + "1 KG per unit", //TODO: implement programmatic dimensions
                                textAlign = TextAlign.Left,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }



                }
            }
        }
    }
}