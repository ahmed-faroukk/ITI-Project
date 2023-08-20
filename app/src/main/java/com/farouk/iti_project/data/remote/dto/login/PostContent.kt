package com.farouk.iti_project.data.remote.dto.login



data class PostContent(
    val body: String,
    val id: Int,
    val reactions: Int,
    val tags: List<String>,
    val title: String,
    val userId: Int
)
