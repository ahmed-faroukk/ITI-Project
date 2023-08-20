package com.farouk.iti_project.data.repository

import com.farouk.iti_project.data.remote.PostApiInterface
import com.farouk.iti_project.data.remote.dto.comment.Comments
import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.data.remote.dto.login.LoginResponse
import com.farouk.iti_project.data.remote.dto.login.PostsDto
import com.farouk.iti_project.domin.repository.AppRepo
import javax.inject.Inject

class PostRepoImp @Inject constructor(
    val api : PostApiInterface
) : AppRepo {


    override suspend fun loginRequest(loginRequest: LoginRequest): LoginResponse = api.login(loginRequest)

    override suspend fun getPosts(): PostsDto = api.fetchPosts()

    override suspend fun getComments(postId: Int): Comments = api.getPostComments(postId)
}