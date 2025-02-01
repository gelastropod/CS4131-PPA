package com.example.cs4131_ppa.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass

class ProductDetailsPageClass {
    companion object {
        @Composable
        fun ProductDetailsPage(navController: NavController, productID: Int) {
            TitleBarClass.TitleBar (navController) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Product ID: $productID")
                    Button(
                        onClick = { navController.navigate("paymentPage/$productID") }
                    ) {
                        Text("Pay")
                    }
                }
            }
        }
    }
}