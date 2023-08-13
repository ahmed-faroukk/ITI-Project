package com.farouk.iti_project.domin.repository

import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.domin.model.Post

interface AppRepo {

    suspend fun getUsers() : Post

    suspend fun loginRequest(loginRequest: LoginRequest) : LoginResponse

}