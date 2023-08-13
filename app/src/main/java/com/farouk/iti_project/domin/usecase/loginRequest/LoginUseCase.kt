package com.farouk.iti_project.domin.usecase.loginRequest

import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.data.remote.dto.login.LoginResponse
import com.farouk.iti_project.domin.repository.AppRepo
import com.plcoding.cryptocurrencyappyt.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repo: AppRepo,
) {
    operator fun invoke(loginRequest: LoginRequest): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repo.loginRequest(loginRequest)
            emit(Resource.Success(response))

        } catch (t: Throwable) {
            emit(Resource.Error(t.message.toString(), null))

        }
    }
}