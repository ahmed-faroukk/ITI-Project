package com.farouk.iti_project.domin.usecase.getpostCommetsById

import com.farouk.iti_project.data.remote.dto.comment.Comments
import com.farouk.iti_project.domin.repository.AppRepo
import com.plcoding.cryptocurrencyappyt.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    val repo : AppRepo
) {
    operator fun invoke(postId : Int) : Flow<Resource<Comments>> = flow {
        try {
            emit(Resource.Loading())
            val response = repo.getComments(postId)
            emit(Resource.Success(response))
        }catch (t : Throwable){
            emit(Resource.Error(t.message.toString() , null))
        }
    }
}