package com.example.cs4131_ppa.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xffCFD8DC),
    onPrimary = Color(0xff212121),
    secondary = Color(0xff795548),
    onSecondary = Color(0xff757575),
    background = Color(0xff455A64),
    surface = Color(0xff607D8B)
)

private val LightColorScheme = lightColorScheme( //TODO: Customise light theme
    primary = Color(0xffCFD8DC),
    onPrimary = Color(0xff212121),
    secondary = Color(0xff795548),
    onSecondary = Color(0xff757575),
    background = Color(0xff455A64),
    surface = Color(0xff607D8B)
)

private val altColourSchemeDark = darkColorScheme(
    primary = Color(0xffFFECB3),
    onPrimary = Color(0xff212121),
    secondary = Color(0xff448AFF),
    onSecondary = Color(0xff757575),
    background = Color(0xffFFA000),
    surface = Color(0xffFFC107)
)

private val altColourSchemeLight = darkColorScheme(
    primary = Color(0xffFFECB3),
    onPrimary = Color(0xff212121),
    secondary = Color(0xff448AFF),
    onSecondary = Color(0xff757575),
    background = Color(0xffFFA000),
    surface = Color(0xffFFC107)
)

@Composable
fun CS4131PPATheme(darkTheme : Boolean = isSystemInDarkTheme(), content : @Composable () -> Unit) {
    //val useDynamicColours = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val useDynamicColours = false

    val c = when {
        //useDynamicColours && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        //useDynamicColours && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        //darkTheme -> DarkColorScheme
        darkTheme -> DarkColorScheme
        else -> DarkColorScheme
    }

    MaterialTheme(
        colorScheme = c,
        typography = Typography,
        content = content
    )
}