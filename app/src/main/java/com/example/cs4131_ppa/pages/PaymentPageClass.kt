package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass

class PaymentPageClass {
    companion object {
        @Composable
        fun PaymentPage(navController: NavController) {
            TitleBarClass.TitleBar (navController) {
                Text("Payment Page")
                Button(onClick = { navController.navigate("homePage") }) {
                    Text("Home Page")
                }
            }
        }
    }
}