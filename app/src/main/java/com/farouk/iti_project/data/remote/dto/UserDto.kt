package com.farouk.iti_project.data.remote.dto

data class UserDto(
    val data : List<UserData>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)