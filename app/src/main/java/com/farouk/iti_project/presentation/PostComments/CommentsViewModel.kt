package com.farouk.iti_project.presentation.PostComments

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farouk.iti_project.domin.usecase.getpostCommetsById.GetCommentsUseCase
import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    val getCommentsUseCase: GetCommentsUseCase,
    saveStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(GetCommentsState())
    var state = _state

    init {
       saveStateHandle.get<String>(Constants.PARAM_POST_ID)?.let {
            getPostCommentsById(it.toInt())
        }
    }

    fun getPostCommentsById(postId : Int){
        getCommentsUseCase(postId).onEach {
            when(it){
                is Resource.Success->{
                    _state.value = GetCommentsState(data = it.data!!)
                }
                is Resource.Error->{
                    _state.value = GetCommentsState(error = it.message.toString())
                }
                is Resource.Loading->{
                    _state.value = GetCommentsState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

}