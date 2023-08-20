package com.farouk.iti_project.data.remote.dto.comment

data class Comment(
    val body: String,
    val id: Int,
    val postId: Int,
    val user: User
)