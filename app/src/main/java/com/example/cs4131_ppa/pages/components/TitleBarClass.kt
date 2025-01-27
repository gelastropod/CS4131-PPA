package com.example.cs4131_ppa.pages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.ui.theme.Accent
import com.example.cs4131_ppa.ui.theme.Primary

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
            ) {
                TitleBarTopContent(navController)
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Row (
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        content()
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    TitleBarBottomContent(navController)
                }
            }
        }
    }
}

@Composable
fun TitleBarTopContent(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Accent)
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (modifier = Modifier.weight(3.0f)) {}
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .weight(5.0f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
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
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {navController.navigate("companyDetailsPage")}
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.information),
                    contentDescription = "Company Details Icon",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Primary)
                )
            }
        }
        Button (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {navController.navigate("homePage")}
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home Page Icon",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Primary)
                )
            }
        }
        Button (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {navController.navigate("signUpPage")}
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "Sign Up Page Icon",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Primary)
                )
            }
        }
    }
}