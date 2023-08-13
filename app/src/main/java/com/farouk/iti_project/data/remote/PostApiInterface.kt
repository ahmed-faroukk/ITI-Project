package com.farouk.iti_project.data.remote

import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.data.remote.dto.login.LoginResponse
import com.farouk.iti_project.domin.model.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostApiInterface {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("users")
    suspend fun getUsers() : Post

    @GET("posts")
    suspend fun getPosts() : Post

    @GET("posts")
    suspend fun getPostsById(@Query("userId") postId : Int) : Post

    @GET("posts/{post_id}/comments")
    suspend fun getComments(@Query("userId") postId : Int) : Post

}