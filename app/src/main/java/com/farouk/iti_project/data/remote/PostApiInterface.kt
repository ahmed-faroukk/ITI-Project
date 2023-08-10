package com.farouk.iti_project.data.remote

import com.farouk.iti_project.domin.model.Post
import retrofit2.http.GET

interface PostApiInterface {

    @GET("users")
    suspend fun getUsers() : Post

}