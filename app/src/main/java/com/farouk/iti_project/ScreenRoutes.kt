package com.farouk.iti_project

sealed class ScreenRoutes(val route : String){
    object PostsListScreen : ScreenRoutes("posts_list_screen")
    object AuthScreen : ScreenRoutes("authentication_screen")
}
