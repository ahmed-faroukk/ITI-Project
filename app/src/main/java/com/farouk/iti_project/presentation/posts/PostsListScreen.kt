package com.farouk.iti_project.presentation.posts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.farouk.iti_project.R
import com.farouk.iti_project.presentation.posts.components.Post
import com.farouk.iti_project.presentation.posts.components.PostListItem


@Composable
fun PostListScreen(
    navController: NavController
){
    val profilePic = R.drawable.man
    val postImage1 = R.drawable.leb
    val postImage2 = R.drawable.messi
    val post = mutableListOf<Post>()
    post.add(
        Post(
            profilePic,
            "Ahmed Farouk ",
            "@ahmedfaaroukk",
            postImage1,
            "MVP this year for lebron !!!!"
        )
    )
    post.add(
        Post(
            profilePic,
            "Ahmed Farouk ",
            "@ahmedfaaroukk",
            postImage2,
            "Balloon Door  this year for leo !!!!"
        )
    )
    post.add(
        Post(
            profilePic,
            "Ahmed Farouk ",
            "@ahmedfaaroukk",
            postImage1,
            "MVP this year for lebron !!!!"
        )
    )
    post.add(
        Post(
            profilePic,
            "Ahmed Farouk ",
            "@ahmedfaaroukk",
            postImage2,
            "Balloon Door  this year for leo !!!!"
        )
    )
    post.add(
        Post(
            profilePic,
            "Ahmed Farouk ",
            "@ahmedfaaroukk",
            postImage1,
            "MVP this year for lebron !!!!"
        )
    )
    post.add(
        Post(
            profilePic,
            "Ahmed Farouk ",
            "@ahmedfaaroukk",
            postImage2,
            "Balloon Door  this year for leo !!!!"
        )
    )



    LazyColumn{
        items(post){
            PostListItem(post = it)
        }
    }


}