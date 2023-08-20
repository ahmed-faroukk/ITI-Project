package com.farouk.iti_project.data.remote

import com.farouk.iti_project.data.remote.dto.comment.Comments
import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.data.remote.dto.login.LoginResponse
import com.farouk.iti_project.data.remote.dto.login.PostsDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApiInterface {


    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("posts")
    suspend fun fetchPosts(): PostsDto

    @GET("posts/{postId}/comments")
    fun getPostComments(@Path("postId") postId: Int): Comments



}