package com.example.cs4131_ppa.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cs4131_ppa.pages.components.TitleBarClass

class CompanyDetailsPageClass {
    companion object {
        @Composable
        fun CompanyDetailsPage(navController: NavController) {
            TitleBarClass.TitleBar (navController) {
                Text("Company Details Page")
                Button(onClick = { navController.navigate("signUpPage") }) {
                    Text("Sign Up Page")
                }
            }
        }
    }
}