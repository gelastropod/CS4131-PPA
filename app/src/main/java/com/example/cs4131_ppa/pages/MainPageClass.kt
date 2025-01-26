package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class MainPageClass {
    companion object {
        @Composable
        fun MainPage(navController: NavController) {
            Text("Main Page")
            Button(onClick = {navController.navigate("productDetailsPage")}) {
                Text("Product Details Page")
            }
        }
    }
}