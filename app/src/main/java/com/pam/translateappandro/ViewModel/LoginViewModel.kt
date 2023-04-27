package com.pam.translateappandro.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pam.translateappandro.State.LoginState
import com.pam.translateappandro.data.authRepository
import com.pam.translateappandro.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: authRepository
): ViewModel(){

    val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()


    fun loginUser(email:String, password:String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{result->
            when(result)
            {
                is Resource.Success ->{
                    _loginState.send(LoginState(isSuccess = "Login Success!"))
                }
                is Resource.loading ->{
                    _loginState.send(LoginState(isloading = true))
                }
                is Resource.error ->{
                    _loginState.send(LoginState(isError = result.message))
                }
            }
        }
    }



}