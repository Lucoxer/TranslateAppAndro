package com.pam.translateappandro.State

data class LoginState(
    val isloading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
