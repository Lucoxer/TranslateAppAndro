package com.pam.translateappandro.State

data class SignUpState(
    val isloading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
