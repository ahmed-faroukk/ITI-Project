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

@Composable
fun HomeScreen() {
    var text by remember { mutableStateOf("Click a button") }
    var isNameVisible by remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutLineTextFieldSample(onNameChange = { newName ->
            text = newName
        })
        Spacer(modifier = Modifier.height(16.dp))
        Btn {
            isNameVisible = true
        }
        if (isNameVisible) {
            Text(text = text)
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextFieldSample(onNameChange: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
            onNameChange(it.text)
        }
    )
}

@Composable
fun Btn(onClick: () -> Unit) {
    Button(onClick = {

    }) {
        Text(text = "show my name ")
    }
}

