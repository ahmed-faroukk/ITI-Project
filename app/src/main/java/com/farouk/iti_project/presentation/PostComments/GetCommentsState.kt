package com.farouk.iti_project.presentation.PostComments

import com.farouk.iti_project.data.remote.dto.comment.Comments

data class GetCommentsState(
    val isLoading :Boolean = false,
    val data : Comments = Comments(
        emptyList() , 0 ,0,0
    ),
    val error : String = ""
)
