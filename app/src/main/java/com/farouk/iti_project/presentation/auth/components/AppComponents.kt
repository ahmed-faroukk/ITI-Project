package com.farouk.iti_project.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

val orange = Color(0xFFCF5827)
val gray = Color(0xFFE7E7E7)
val blue = Color(0xFF2196F3)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextFieldMail(onNameChange: (String) -> Unit, txt: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = txt) },
        onValueChange = {
            text = it
            onNameChange(it.text)
        }, colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black, // Set the desired text color
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = blue,
            focusedLabelColor = blue
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextFieldPass(onNameChange: (String) -> Unit, txt: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = txt) },
        onValueChange = {
            text = it
            onNameChange(it.text)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = blue,
            focusedLabelColor = blue
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
}


@Composable
fun Btn(onClick: () -> Unit, txt: String) {
    Button(onClick = onClick) {
        Text(text = txt)
    }
}

@Composable
fun CheckBox(onCheckChanges: (Boolean) -> Unit, sportType: String) {
    var sport by remember {
        mutableStateOf(false)
    }
    Column {
        // Football checkbox
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = sport,
                onCheckedChange = {
                    sport = it
                    onCheckChanges(sport)
                },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = blue,
                    checkedColor = Color.White
                )

            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = sportType, modifier = Modifier.width(110.dp), color = Color.Black)
        }

    }
}

enum class Gender {
    MALE,
    FEMALE
}

@Composable
fun GenderSelection(onGenderClicked: (Gender) -> Unit, modifier: Modifier = Modifier) {
    var selectedGender by remember { mutableStateOf(Gender.MALE) }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        // Male radio button
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedGender == Gender.MALE,
                colors = RadioButtonDefaults.colors(
                    selectedColor = blue, disabledSelectedColor = Color.White
                ),
                onClick = { selectedGender = Gender.MALE }

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Male", color = Color.Black)
        }

        // Female radio button
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedGender == Gender.FEMALE,
                colors = RadioButtonDefaults.colors(
                    selectedColor = blue, disabledSelectedColor = Color.White
                ),
                onClick = { selectedGender = Gender.FEMALE }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Female", color = Color.Black)
        }
    }
}


@Composable
fun CustomToast(message: String) {
    Snackbar(
        action = {

        },
        modifier = Modifier.padding(16.dp) ,

    ) {
        Text(text = message, color = Color.White)
    }
}

