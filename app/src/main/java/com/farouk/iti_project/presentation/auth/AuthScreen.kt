package com.farouk.iti_project.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farouk.iti_project.R
import com.farouk.iti_project.presentation.components.OutLineTextFieldMail
import com.farouk.iti_project.presentation.components.OutLineTextFieldPass

@Composable
fun AuthScreen() {
    var mail by remember { mutableStateOf("Click a button") }
    var mailAfterClick by remember { mutableStateOf("Click a button") }
    val gray = Color(0xFF3C3C3C)
    val blue = Color(0xFF2196F3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(R.string.login_form), color = Color.White , fontWeight = FontWeight.Bold , fontSize = 50.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 25.dp ,end = 45.dp)) {
            Text(text = stringResource(R.string.username), color = Color.White , )
            OutLineTextFieldMail(onNameChange = { newName ->
                mail = newName
            }, txt = stringResource(R.string.enter_your_mail))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier.padding(start = 25.dp ,end = 45.dp)) {
            Text(text = stringResource(R.string.password), color = Color.White)
            OutLineTextFieldPass(onNameChange = { newName ->
                mail = newName
            }, txt = stringResource(R.string.enter_your_password))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            /*TODO*/

        }, colors = ButtonDefaults.buttonColors(blue),
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp)
                .wrapContentSize(align = Alignment.Center)
                .fillMaxWidth()
                ) {
            Text(text = stringResource(R.string.login_now), color = Color.White)

        }

    }

}