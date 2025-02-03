package com.example.cs4131_ppa.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass

class PaymentPageClass {
    companion object {
        @Composable
        fun PaymentPage(navController: NavController, productID: Int) {
            TitleBarClass.TitleBar (navController) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Payment successful!",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {navController.navigate("productDetailsPage/$productID")}
                    ) {
                        Text("Return to homepage")
                    }
                }
            }
        }
    }
}