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

class PaymentDonePageClass {
    companion object {
        @Composable
        fun PaymentDonePage(navController: NavController) {
            TitleBarClass.TitleBar(navController) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Payment Successful!",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {navController.navigate("homePage")}
                    ) {
                        Text("Done")
                    }
                }
            }
        }
    }
}