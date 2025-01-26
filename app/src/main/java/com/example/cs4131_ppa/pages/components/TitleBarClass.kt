package com.example.cs4131_ppa.pages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R

class TitleBarClass {
    companion object {
        @Composable
        fun TitleBar(
            navController: NavController,
            content: @Composable () -> Unit
        ) {
            Column (
                modifier = Modifier.fillMaxSize()
            ) {
                TitleBarContent(navController)
                content()
            }
        }
    }
}

@Composable
fun TitleBarContent(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ppg_logo_icon_foreground),
                contentDescription = "App Icon",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "Peak Performance Gear",
                modifier = Modifier.width(150.dp)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button (
                onClick = {navController.navigate("companyDetailsPage")},
                modifier = Modifier
                    .fillMaxHeight()
                    .width(50.dp)
            ) {
                Text("Company Info")
            }
            Button (
                onClick = {navController.navigate("signUpPage")},
                modifier = Modifier
                    .fillMaxHeight()
                    .width(50.dp)
            ) {
                Text("Sign Up")
            }
        }
    }
}