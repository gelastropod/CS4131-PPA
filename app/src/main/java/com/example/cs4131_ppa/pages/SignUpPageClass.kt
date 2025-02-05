package com.example.cs4131_ppa.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.pages.components.TitleBarClass
import com.example.cs4131_ppa.pages.model.User

class SignUpPageClass {
    companion object {
        @Composable
        fun SignUpPage(navController: NavController) {
            val usernameState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }
            val isPasswordVisible = remember { mutableStateOf(false) }
            val context = LocalContext.current

            TitleBarClass.TitleBar (navController) {
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sign Up",
                        style = MaterialTheme.typography.titleLarge
                    )
                    TextField(
                        value = usernameState.value,
                        onValueChange = { newText -> usernameState.value = if (!newText.contains("\n")) newText else usernameState.value },
                        label = { Text("Enter Username") },
                        placeholder = { Text("Username...") }
                    )
                    TextField(
                        value = passwordState.value,
                        onValueChange = { newText -> passwordState.value = if (!newText.contains("\n")) newText else passwordState.value },
                        label = { Text("Enter Password") },
                        visualTransformation = if (isPasswordVisible.value) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                isPasswordVisible.value = !isPasswordVisible.value
                            }) {
                                Icon(
                                    painter = if (isPasswordVisible.value) {
                                        painterResource(R.drawable.eye)
                                    } else {
                                        painterResource(R.drawable.eye_off)
                                    },
                                    contentDescription = "Toggle password visibility"
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            var usernamePassed= true
                            var passwordPassed = true
                            val username = usernameState.value
                            val password = passwordState.value

                            if (username in User.usernameList)
                                usernamePassed = false
                            if (!username.matches("^[a-zA-Z0-9_-]{3,15}$".toRegex()))
                                usernamePassed = false

                            if (password.length < 8)
                                passwordPassed = false
                            if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[A-Za-z0-9!@#\$%^&*]{8,}$".toRegex()))
                                passwordPassed = false

                            if (!usernamePassed)
                                Toast.makeText(context, "Username is invalid!", Toast.LENGTH_SHORT).show()
                            if (!passwordPassed)
                                Toast.makeText(context, "Password is invalid!", Toast.LENGTH_SHORT).show()

                            val user = User(username, password)
                        }
                    ) {
                        Text("Sign Up")
                    }
                }
            }
        }
    }
}