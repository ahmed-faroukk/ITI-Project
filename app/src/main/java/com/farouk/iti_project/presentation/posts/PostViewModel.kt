package com.farouk.iti_project.presentation.posts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farouk.iti_project.domin.model.Post
import com.farouk.iti_project.domin.usecase.getPosts.GetPostsUseCase
import com.plcoding.cryptocurrencyappyt.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    val postsUseCase: GetPostsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(PostListState())
    var state = _state

    init {
        getPosts()
    }

    private fun getPosts(){
        postsUseCase().onEach { response->

            when(response){
                is Resource.Success -> {
                    state.value = PostListState(data = Post(response.data!!.data))
                }
                is Resource.Error -> {
                    state.value = PostListState(error = response.message.toString())

                }
                is Resource.Loading -> {
                    state.value = PostListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}