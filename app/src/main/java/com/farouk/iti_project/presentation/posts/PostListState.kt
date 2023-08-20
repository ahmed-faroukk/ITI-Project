package com.farouk.iti_project.presentation.posts

import com.farouk.iti_project.data.remote.dto.login.PostsDto

data class PostListState(
    val isLoading :Boolean = false,
    val data : PostsDto = PostsDto(
        0 , emptyList() , 0 , 0
    ),
    val error : String = ""
)
