package com.farouk.iti_project.data.repository

import com.farouk.iti_project.data.remote.PostApiInterface
import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.data.remote.dto.login.LoginResponse
import com.farouk.iti_project.domin.model.Post
import com.farouk.iti_project.domin.repository.AppRepo
import javax.inject.Inject

class PostRepoImp @Inject constructor(
    val api : PostApiInterface
) : AppRepo {
    override suspend fun getUsers(): Post  = api.getUsers()

    override suspend fun loginRequest(loginRequest: LoginRequest): LoginResponse = api.login(loginRequest)
}