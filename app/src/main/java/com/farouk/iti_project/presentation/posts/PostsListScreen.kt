package com.farouk.iti_project.presentation.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farouk.iti_project.presentation.navigation.ScreenRoutes
import com.farouk.iti_project.presentation.posts.components.PostListItem


@Composable
fun PostListScreen(
    navController: NavController,
    viewModel: PostViewModel = hiltViewModel(),
){

    var newPost by remember {
        mutableStateOf("")
    }
    val state = viewModel.state.value
    if (state.isLoading){
        Column(modifier = Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){
            CircularProgressIndicator()

        }
    }
    if (state.error.isNotEmpty()){
        Text(text = state.error)
    }


    LazyColumn{
        items(state.data.data){post->
            PostListItem(user = post , onItemClick = {
                   navController.navigate(ScreenRoutes.PostDetailScreen.route + "/${post.id}")
            })
        }
    }
}





