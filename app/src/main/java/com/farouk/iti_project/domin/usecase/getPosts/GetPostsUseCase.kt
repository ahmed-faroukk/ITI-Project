package com.farouk.iti_project.domin.usecase.getPosts

import com.farouk.iti_project.domin.model.Post
import com.farouk.iti_project.domin.repository.AppRepo
import com.plcoding.cryptocurrencyappyt.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repo : AppRepo
){
    operator fun invoke() : Flow<Resource<Post>> = flow {
        try {
            emit(Resource.Loading())
            val response = repo.getUsers()
            emit(Resource.Success(response))

        }catch (e : Throwable){
            emit(Resource.Error(e.message.toString() , null))
        }

    }
}