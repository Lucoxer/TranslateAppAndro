package com.pam.translateappandro.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(modifier = Modifier.padding(top = 80.dp)) {
            Text(
                text = "Hi, Welcome Back",
                fontSize = 24.sp,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 149.dp)
        ) {
            OutlinedTextField(
                value = emailInput.toString(),
                onValueChange = { emailInput = it },
                label = { Text(text = "Enter Your Email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(29, 196, 206),
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color(29, 196, 206)
                ),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = passwordInput.toString(),
                onValueChange = { passwordInput = it },
                label = { Text(text = "Enter Your Password") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(29, 196, 206),
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color(29, 196, 206)
                ),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }

        Row(modifier = Modifier.padding(top = 170.dp)) {
            //Remember me & CHANGE PASSWORD BELUM
            Column() {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(14, 100, 210),
                        contentColor = Color.White
                    ),
                    shape = CutCornerShape(10)
                ) {
                    Text(
                        text = "Login",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}
//
@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}