package com.pam.translateappandro.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pam.translateappandro.State.SignUpState
import com.pam.translateappandro.data.authRepository
import com.pam.translateappandro.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: authRepository
): ViewModel(){

    val _signupState = Channel<SignUpState>()
    val signupState = _signupState.receiveAsFlow()


    fun registeruser(email:String, password:String) = viewModelScope.launch {
        repository.registerUser(email, password).collect{result->
            when(result)
            {
                is Resource.Success ->{
                    _signupState.send(SignUpState(isSuccess = "Sign Up Success!"))
                }
                is Resource.loading ->{
                    _signupState.send(SignUpState(isloading = true))
                }
                is Resource.error ->{
                    _signupState.send(SignUpState(isError = result.message))
                }
            }
        }
    }
}