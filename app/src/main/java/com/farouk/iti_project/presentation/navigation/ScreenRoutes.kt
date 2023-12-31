package com.farouk.iti_project.presentation.navigation

sealed class ScreenRoutes(val route : String){
    object PostsListScreen : ScreenRoutes("posts_list_screen")
    object AuthScreen : ScreenRoutes("authentication_screen")
    object CommentsDetailScreen : ScreenRoutes("Comments_detail_screen"){
    }
}
