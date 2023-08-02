@file:Suppress("UNUSED_EXPRESSION")

package com.farouk.iti_project.presentation.home

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.farouk.iti_project.presentation.components.Btn
import com.farouk.iti_project.presentation.components.OutLineTextFieldMail

@Composable
fun HomeScreen() {
    var text by remember { mutableStateOf("Click a button") }
    var text1 by remember { mutableStateOf("test") }
    var isNameVisible by remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text1)
        Spacer(modifier = Modifier.height(16.dp))
        OutLineTextFieldMail(onNameChange = { newName ->
            text = newName
        }, txt = "Enter Your Name")
        Spacer(modifier = Modifier.height(16.dp))
        Btn(onClick = { text1 = text }, txt = "show my name")

    }
}

