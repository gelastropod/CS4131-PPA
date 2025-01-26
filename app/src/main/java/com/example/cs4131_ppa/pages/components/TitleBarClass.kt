package com.example.cs4131_ppa.pages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.ui.theme.Accent

class TitleBarClass {
    companion object {
        @Composable
        fun TitleBar(
            navController: NavController,
            content: @Composable () -> Unit
        ) {

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TitleBarTopContent(navController)
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    content()
                    Spacer(modifier = Modifier.weight(1f))
                    TitleBarBottomContent(navController)
                }
            }
        }
    }
}

@Composable
fun TitleBarTopContent(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp)
            .background(Accent),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
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
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TitleBarBottomContent(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Accent),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {navController.navigate("companyDetailsPage")}
        ) {
            // Info icon
        }
        Button (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {navController.navigate("homePage")}
        ) {
            // Home icon
        }
        Button (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {navController.navigate("signUpPage")}
        ) {
            // Sign Up icon
        }
    }
}