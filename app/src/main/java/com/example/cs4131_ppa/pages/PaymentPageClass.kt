package com.example.cs4131_ppa.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

class PaymentPageClass {
    companion object {
        @Composable
        fun PaymentPage(navController: NavController) {
            val productList = Product.returnPairProductsCart()
            val context = LocalContext.current

            var totalPrice = 0f
            for (p in productList) {
                totalPrice += p.first.price + p.second.price
            }

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
                        Text(
                            text = "Your cart: $%.2f".format(totalPrice),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    items(productList) { productPair ->
                        ProductCard(navController, productPair, true)
                    }
                    item {
                        Button(
                            onClick = {
                                if (productList.size == 0) {
                                    Toast.makeText(context, "Cart is empty!", Toast.LENGTH_SHORT).show()
                                } else {
                                    navController.navigate("paymentDonePage")
                                    Product.clearItems()
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Pay")
                            Box(
                                modifier = Modifier.width(3.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.credit_card_outline),
                                contentDescription = "Pay"
                            )
                        }
                    }
                    item {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {navController.navigate("homePage")}
                        ) {
                            Text("Continue shopping...")
                        }
                    }
                }
            }
        }
    }
}