package com.farouk.iti_project.data.remote.dto.comment

data class Comments(
    val comments: List<Comment>,
    val limit: Int,
    val skip: Int,
    val total: Int
)