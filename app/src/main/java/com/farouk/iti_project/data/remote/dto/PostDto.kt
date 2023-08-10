package com.farouk.iti_project.data.remote.dto

data class PostDto(
    val data : List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)