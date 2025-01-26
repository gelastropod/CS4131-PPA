package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass

class ProductDetailsPageClass {
    companion object {
        @Composable
        fun ProductDetailsPage(navController: NavController) {
            TitleBarClass.TitleBar (navController) {
                Text("Product Details Page")
                Button(onClick = { navController.navigate("companyDetailsPage") }) {
                    Text("Company Details Page")
                }
            }
        }
    }
}