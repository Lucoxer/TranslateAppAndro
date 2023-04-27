@file:OptIn(ExperimentalMaterialApi::class)

package com.pam.translateappandro.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pam.translateappandro.R
import com.pam.translateappandro.ViewModel.sharedViewModel


@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    sharedViewModel: sharedViewModel,
){
    var expanded by remember { mutableStateOf(false) }
    var toTrans by remember { mutableStateOf("") }
    var trans by remember { mutableStateOf("") }
    var name by rememberSaveable{ mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val setUserInformation = sharedViewModel.person
    val user = Firebase.auth.currentUser!!


    sharedViewModel.retrieveData(
        email = setUserInformation!!.email,
        context = context
    ){
            data ->
        name = data.name
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = " Hello, $name",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }


    Column(modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "English")
        TextField(
            value = toTrans.toString(),
            onValueChange = {toTrans = it},
            label = {Text(text = "Input Text to be Translate")},
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Translate")
        }
        Spacer(modifier = Modifier.height(70.dp))
        Text(text = "Indonesia")
        TextField(
            value = trans.toString(),
            onValueChange = {trans = it},
            label = {Text(text = "Your Translate")},
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        )
    }
}