package com.example.cs4131_ppa.pages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.ui.theme.Accent
import com.example.cs4131_ppa.ui.theme.Primary

class TitleBarClass {
    companion object {
        @Composable
        fun TitleBar(
            navController: NavController,
            content: @Composable (height: MutableState<Size>) -> Unit
        ) {
            val sizeState = remember { mutableStateOf(Size(0f, 0f)) }

            Column (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TitleBarTopContent()
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Box (
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                            .onSizeChanged { size: IntSize ->
                                sizeState.value = size.toSize()
                            }
                    ) {
                        content(sizeState)
                    }
                    TitleBarBottomContent(navController)
                }
            }
        }
    }
}

@Composable
fun TitleBarTopContent() {
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
    val route = navController.currentBackStackEntry?.destination?.route

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
            onClick = {if (route != "companyDetailsPage") navController.navigate("companyDetailsPage")}
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
                        .background(if (route == "companyDetailsPage") Primary else Accent)
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
            onClick = {if (route != "homePage") navController.navigate("homePage")}
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
                        .background(if (route == "homePage") Primary else Accent)
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
            onClick = {if (route != "paymentPage") navController.navigate("paymentPage")}
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.credit_card_outline),
                    contentDescription = "Payment Page Icon",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(if (route == "paymentPage") Primary else Accent)
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
            onClick = {if (route != "signUpPage") navController.navigate("signUpPage")}
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
                        .background(if (route == "signUpPage") Primary else Accent)
                )
            }
        }
    }
}