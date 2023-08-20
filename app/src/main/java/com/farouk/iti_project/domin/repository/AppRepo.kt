package com.farouk.iti_project.domin.repository

import com.farouk.iti_project.data.remote.dto.comment.Comments
import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.data.remote.dto.login.LoginResponse
import com.farouk.iti_project.data.remote.dto.login.PostsDto

interface AppRepo {

    suspend fun loginRequest(loginRequest: LoginRequest) : LoginResponse

    suspend fun getPosts() : PostsDto

    suspend fun getComments(postId : Int ) : Comments

}