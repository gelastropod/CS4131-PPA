package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass

class MainPageClass {
    companion object {
        @Composable
        fun MainPage(navController: NavController) {
            TitleBarClass.TitleBar (navController) {
                Text("Home Page")
                Button(onClick = { navController.navigate("productDetailsPage") }) {
                    Text("Product Details Page")
                }
            }
        }
    }
}