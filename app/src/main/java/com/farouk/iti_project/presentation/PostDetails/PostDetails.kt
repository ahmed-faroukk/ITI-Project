package com.farouk.iti_project.presentation.PostDetails

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.farouk.iti_project.R
import com.farouk.iti_project.data.remote.dto.UserData
import kotlinx.coroutines.launch

@Composable
fun PostListItem(
    post : UserData
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            CircularImage(imageResource = post.avatar)
            Column {
                Text(
                    text = post.first_name + " " + post.last_name,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = post.email,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal
                )

            }
        }


        BlackSpacer()
        PostImage(imageResource = post.avatar)
        BlackSpacer()
        Text(text = "3k likes" , fontWeight = FontWeight.Light , fontSize = 15.sp)
        HeartAnimation()

        Row {
            Text(
                text = "${post.first_name} : ",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "post content",
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Text(text = "5 minutes ago" , fontWeight = FontWeight.Light , fontSize = 10.sp)




    }
}


@Composable
fun CircularImage(imageResource: String) {


    Image(
        painter = rememberAsyncImagePainter(imageResource),
        contentDescription = "profile pic",
        modifier = Modifier
            .padding(end = 10.dp)
            .size(30.dp)
            .clip(CircleShape)

    )
}

@Composable
fun PostImage(imageResource: String) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageResource),
            contentDescription = "post image ",
            modifier = Modifier
                .size(330.dp)
                .clip(RoundedCornerShape(3.dp)),
            alignment = Alignment.Center
        )

    }


}

@Composable
fun LikeButton(
    modifier: Modifier = Modifier) {
    var isLiked  by  remember {
        mutableStateOf(false)
    }


    // Red heart icon
    Image(
        painter = painterResource(
            id = if (isLiked) R.drawable.like_24 else R.drawable.dislike_24
        ),
        contentDescription = "love btn",
        modifier = Modifier
            .padding(5.dp)
            .size(25.dp)
            .clickable {
                isLiked = !isLiked

            }
    )


}

@Composable
fun BlackSpacer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 1.dp)
            .background(Color.Gray)
    )
}


@Composable
fun HeartAnimation() {

    val interactionSource = MutableInteractionSource()

    val coroutineScope = rememberCoroutineScope()

    var enabled by remember {
        mutableStateOf(false)
    }

    val scale = remember {
        androidx.compose.animation.core.Animatable(1f)
    }

    Icon(
        imageVector = Icons.Outlined.Favorite,
        contentDescription = "Like the product",
        tint = if (enabled) Color.Red else Color.LightGray,
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 27.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                enabled = !enabled
                coroutineScope.launch {
                    scale.animateTo(
                        0.8f,
                        animationSpec = tween(100),
                    )
                    scale.animateTo(
                        1f,
                        animationSpec = tween(100),
                    )
                }
            }
    )
}

