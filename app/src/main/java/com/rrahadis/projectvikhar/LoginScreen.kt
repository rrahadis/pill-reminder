package com.rrahadis.projectvikhar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onNavigateToSecondScreen: () -> Unit,
    modifier: Modifier = Modifier,
){
    var username = ""
    var password = ""
    var isLoginEnabled = false

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome Back!", textAlign = TextAlign.Center, color = Color.Blue, fontSize = 14.sp)
        Text(text = "Sign in to continue", textAlign = TextAlign.Center, color = Color.Black, fontSize = 12.sp)
        Spacer(Modifier.size(16.dp))
        // Input field for username
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            value = username,
            onValueChange = {
                username = it
                isLoginEnabled = username.isNotEmpty() && password.isNotEmpty()
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Username") },
            leadingIcon = { Icon(Icons.Outlined.Email, tint = Color.Blue, contentDescription = null) }
        )

        // Input field for password
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            value = password,
            onValueChange = {
                password = it
                isLoginEnabled = username.isNotEmpty() && password.isNotEmpty()
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Outlined.Lock,tint = Color.Blue, contentDescription = null) }
        )

        Row( modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Checkbox(checked = false, onCheckedChange = {

                })
                Text(text = "Remember Me")
            }
            Text(text = "Forgot Password?", color = Color.Red)

        }


        // Login button
        Button(
            onClick = {
                // Handle login logic here
            },
            shape = RoundedCornerShape(50),
            enabled = isLoginEnabled,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Sign In")
        }

        MultiStyleText(text1 = "Already Have not an account?", color1 = Color.Black, text2 = " Sign Up !", color2 = Color.Red)
    }



}