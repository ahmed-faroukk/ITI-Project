package com.farouk.iti_project.presentation.posts

import com.farouk.iti_project.domin.model.Post

data class PostListState(
    val isLoading :Boolean = false,
    val data : Post = Post(emptyList()),
    val error : String = ""
)
