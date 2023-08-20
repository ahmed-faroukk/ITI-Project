package com.farouk.iti_project.presentation.auth

import com.farouk.iti_project.data.remote.dto.login.LoginResponse

data class LoginState(
    val isLoading :Boolean = false,
    val data : LoginResponse ?= null,
    val error : String = "" ,
    val loginSuccessfully  : Boolean = false
)
