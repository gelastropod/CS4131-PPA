package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class PaymentPageClass {
    companion object {
        @Composable
        fun PaymentPage(navController: NavController) {
            Text("Payment Page")
            Button(onClick = {navController.navigate("homePage")}) {
                Text("Home Page")
            }
        }
    }
}