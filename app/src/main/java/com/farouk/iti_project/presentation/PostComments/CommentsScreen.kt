package com.farouk.iti_project.presentation.PostComments


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farouk.iti_project.presentation.PostComments.compnents.PostCommentsItem

@Composable
fun CommentsDetailScreen(
    viewModel: CommentsViewModel = hiltViewModel(),
) {


    val state = viewModel.state.value
    if (state.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()

        }
    }
    if (state.error.isNotEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = state.error)
        }
    }


    LazyColumn(Modifier.padding(25.dp)) {
        item {
            Text(text = "Comments", fontWeight = FontWeight.ExtraBold)
        }
        items(state.data.comments) { comment ->
            PostCommentsItem(comment = comment)
            Divider()


        }
    }
}





