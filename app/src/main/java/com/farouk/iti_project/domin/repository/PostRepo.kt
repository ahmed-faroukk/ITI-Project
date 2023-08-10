package com.farouk.iti_project.domin.repository

import com.farouk.iti_project.data.remote.PostApiInterface
import com.farouk.iti_project.domin.model.Post
import javax.inject.Inject

interface PostRepo {

    suspend fun getUsers() : Post

}