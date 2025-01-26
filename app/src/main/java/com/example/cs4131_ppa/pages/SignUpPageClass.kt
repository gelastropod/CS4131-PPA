package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class SignUpPageClass {
    companion object {
        @Composable
        fun SignUpPage(navController: NavController) {
            Text("Sign Up Page")
            Button(onClick = {navController.navigate("paymentPage")}) {
                Text("Payment Page")
            }
        }
    }
}