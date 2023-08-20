package com.farouk.iti_project.data.remote.dto.login


data class PostsDto(
    val limit: Int,
    val posts: List<PostContent>,
    val skip: Int,
    val total: Int,
)

