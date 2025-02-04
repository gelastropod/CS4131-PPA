package com.example.cs4131_ppa

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cs4131_ppa.pages.CompanyDetailsPageClass
import com.example.cs4131_ppa.ui.theme.CS4131PPATheme
import com.example.cs4131_ppa.pages.MainPageClass
import com.example.cs4131_ppa.pages.PaymentDonePageClass
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
                    MainApp(resources)
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
fun MainApp(resources: Resources) {
    val navController = rememberNavController()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    NavHost(
        navController = navController,
        startDestination = "homePage",
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                })
            }
    ) {
        composable("homePage") { MainPageClass.MainPage(navController, resources) }
        composable(
            "productDetailsPage/{productID}/{fromCart}",
            arguments = listOf(
                navArgument("productID") {type = NavType.StringType},
                navArgument("fromCart") {type = NavType.StringType}
            )
        ) { backStackEntry ->
            val productID = backStackEntry.arguments?.getString("productID")
            val fromCart = backStackEntry.arguments?.getString("fromCart")
            if (productID != null) {
                ProductDetailsPageClass.ProductDetailsPage(navController, productID.toInt(), fromCart.equals("1"))
            }
        }
        composable("companyDetailsPage") { CompanyDetailsPageClass.CompanyDetailsPage(navController) }
        composable("signUpPage") { SignUpPageClass.SignUpPage(navController) }
        composable("paymentPage") { PaymentPageClass.PaymentPage(navController) }
        composable("paymentDonePage") { PaymentDonePageClass.PaymentDonePage(navController) }
    }
}