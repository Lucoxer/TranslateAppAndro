package com.pam.translateappandro.data

import com.google.firebase.auth.AuthResult
import com.pam.translateappandro.util.Resource
import kotlinx.coroutines.flow.Flow

interface authRepository {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
}