package com.pam.translateappandro.ui.screens

import android.content.Intent
import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen (){
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var Username by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) {
            Text(
                text = "STRANS",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }

        Card(modifier = Modifier
            .padding(top = 200.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .fillMaxWidth()
            .height(600.dp)
            .align(Alignment.Center),
            backgroundColor = MaterialTheme.colors.surface,
        ){
            Column()
            {
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = "REGISTER",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(29, 196, 206),
                    )
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)){
                OutlinedTextField(
                    value = emailInput.toString(),
                    onValueChange = { emailInput = it},
                    label = { Text(text = "Email" ) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(29, 196, 206),
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color(29, 196, 206)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                OutlinedTextField(
                    value = Username.toString(),
                    onValueChange = { Username = it },
                    label = { Text(text = "Nama")},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(29, 196, 206),
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color(29, 196, 206)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Username"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                OutlinedTextField(
                    value = passwordInput.toString(),
                    onValueChange = { passwordInput = it },
                    label = { Text(text = "Kata Sandi") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(29, 196, 206),
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color(29, 196, 206)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                OutlinedTextField(
                    value = confirmPassword.toString(),
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Konfirmasi Kata Sandi") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(29, 196, 206),
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color(29, 196, 206)
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Confirm Password"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                )
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}