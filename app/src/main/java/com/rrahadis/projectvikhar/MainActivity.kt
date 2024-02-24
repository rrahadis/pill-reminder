package com.rrahadis.projectvikhar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rrahadis.projectvikhar.ui.theme.ProjectVikharTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectVikharTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoAppNavHost()
                }
            }
        }
        setContent {
            ProjectVikharTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}


@Composable
fun LoginScreen() {
    var username = ""
    var password = ""
    var isLoginEnabled = false

    Column(
        modifier = Modifier
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
            modifier = Modifier
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Outlined.Lock,tint = Color.Blue, contentDescription = null) }
        )

        Row( modifier = Modifier.fillMaxWidth(),
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Sign In")
        }

        MultiStyleText(text1 = "Already Have not an account?", color1 = Color.Black, text2 = " Sign Up !", color2 = Color.Red)
    }
}

@Composable
fun MultiStyleText(text1: String, color1: Color, text2: String, color2: Color) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = color1)) {
            append(text1)
        }
        withStyle(style = SpanStyle(color = color2)) {
            append(text2)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectVikharTheme {
        LoginScreen()
    }
}