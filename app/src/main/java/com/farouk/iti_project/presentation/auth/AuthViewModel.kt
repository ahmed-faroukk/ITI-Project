package com.farouk.iti_project.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.domin.usecase.loginRequest.LoginUseCase
import com.plcoding.cryptocurrencyappyt.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    val loginUseCase: LoginUseCase,

) : ViewModel() {

    private val state = mutableStateOf(LoginState())
    var _state = state


    fun loginRequest(loginRequest: LoginRequest) {

        loginUseCase(loginRequest).onEach { response ->

            when (response) {

                is Resource.Success -> {
                    _state.value = LoginState(data = response.data)
                }

                is Resource.Error -> {
                    _state.value = LoginState(error = response.message.toString())

                }

                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }

        }
    }
}