package com.example.cs4131_ppa.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

class SignUpPageClass {
    companion object {
        @Composable
        fun SignUpPage(navController: NavController) {
            Column (
                modifier = Modifier
                    .fillMaxSize() // Ensures the Column takes up the full screen space
                    .padding(16.dp), // Optional padding for spacing
                verticalArrangement = Arrangement.SpaceEvenly, // Spreads children evenly
                horizontalAlignment = Alignment.CenterHorizontally // Aligns children horizontally
            ) {
                Text("Sign Up Page")
                Button(onClick = { navController.navigate("paymentPage") }) {
                    Text("Payment Page")
                }
            }
        }
    }
}