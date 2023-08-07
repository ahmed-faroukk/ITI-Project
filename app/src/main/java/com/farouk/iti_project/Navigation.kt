package com.farouk.iti_project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farouk.iti_project.presentation.auth.AuthScreen
import com.farouk.iti_project.presentation.posts.PostListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoutes.AuthScreen.route) {
        composable(ScreenRoutes.AuthScreen.route) { AuthScreen(navController) }
        composable(ScreenRoutes.PostsListScreen.route) { PostListScreen(navController) }
    }
}