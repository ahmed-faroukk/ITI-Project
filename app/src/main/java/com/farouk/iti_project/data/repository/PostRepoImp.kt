package com.farouk.iti_project.data.repository

import com.farouk.iti_project.data.remote.PostApiInterface
import com.farouk.iti_project.domin.model.Post
import com.farouk.iti_project.domin.repository.PostRepo
import javax.inject.Inject

class PostRepoImp @Inject constructor(
    val api : PostApiInterface
) : PostRepo {
    override suspend fun getUsers(): Post  = api.getUsers()
}