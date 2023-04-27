package com.pam.translateappandro.NavigationGraph

import androidx.lifecycle.viewmodel.compose.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pam.translateappandro.ViewModel.sharedViewModel
import com.pam.translateappandro.ui.screens.ChangePasswordScreen
import com.pam.translateappandro.ui.screens.HomeScreen
import com.pam.translateappandro.ui.screens.LoginScreen
import com.pam.translateappandro.ui.screens.SignUpScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    val sharedViewModel: sharedViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screens.SignUpScreen.route
    ) {

        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        composable(route = Screens.ChangePasswordScreen.route) {
            ChangePasswordScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen( navController = navController, sharedViewModel = sharedViewModel)
        }
    }

}