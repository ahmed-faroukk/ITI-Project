package com.farouk.iti_project.presentation.PostComments.compnents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farouk.iti_project.data.remote.dto.comment.Comment
import com.farouk.iti_project.presentation.posts.components.CircularImage

@Composable
fun PostCommentsItem(
    comment : Comment
){
    Column (Modifier.padding(top = 25.dp , bottom = 25.dp)){
        Row {
            CircularImage(imageResource = "https://static.vecteezy.com/system/resources/previews/002/275/847/original/male-avatar-profile-icon-of-smiling-caucasian-man-vector.jpg")
            Text(text = comment.user.username + " :- " , fontWeight = FontWeight.Bold)
            Text(text = comment.body)
        }


    }


}