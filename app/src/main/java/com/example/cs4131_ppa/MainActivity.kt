package com.example.cs4131_ppa

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cs4131_ppa.pages.CompanyDetailsPageClass
import com.example.cs4131_ppa.ui.theme.CS4131PPATheme
import com.example.cs4131_ppa.pages.MainPageClass
import com.example.cs4131_ppa.pages.PaymentPageClass
import com.example.cs4131_ppa.pages.ProductDetailsPageClass
import com.example.cs4131_ppa.pages.SignUpPageClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        enableImmersiveMode()
        setContent {
            CS4131PPATheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }

    private fun enableImmersiveMode() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }
}

// Main App
@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homePage") {
        composable("homePage") { MainPageClass.MainPage(navController) }
        composable("productDetailsPage") { ProductDetailsPageClass.ProductDetailsPage(navController) }
        composable("companyDetailsPage") { CompanyDetailsPageClass.CompanyDetailsPage(navController) }
        composable("signUpPage") { SignUpPageClass.SignUpPage(navController) }
        composable("paymentPage") { PaymentPageClass.PaymentPage(navController) }
    }
}