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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farouk.iti_project.R
import com.farouk.iti_project.data.remote.dto.login.LoginRequest
import com.farouk.iti_project.presentation.navigation.ScreenRoutes
import com.farouk.iti_project.presentation.auth.components.CheckBox
import com.farouk.iti_project.presentation.auth.components.CustomToast
import com.farouk.iti_project.presentation.auth.components.Gender
import com.farouk.iti_project.presentation.auth.components.GenderSelection
import com.farouk.iti_project.presentation.auth.components.OutLineTextFieldMail
import com.farouk.iti_project.presentation.auth.components.OutLineTextFieldPass
import com.farouk.iti_project.presentation.posts.PostViewModel

@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()

    ) {
    var mail by remember { mutableStateOf("Empty") }
    var pass by remember { mutableStateOf("Empty") }
    var cliked by remember { mutableStateOf(false) }
    val gray = Color(0xFF3C3C3C)
    val blue = Color(0xFF2196F3)
    val state = viewModel._state.value



    var footballChecked by remember { mutableStateOf(false) }
    var basketballChecked by remember { mutableStateOf(false) }
    var volleyballChecked by remember { mutableStateOf(false) }
    val hobbiesMap : MutableMap<String , Boolean> = mutableMapOf()
    hobbiesMap["basketball"] = basketballChecked
    hobbiesMap["football"] = footballChecked
    hobbiesMap["volley"] = volleyballChecked

    var selectedGender by remember { mutableStateOf(Gender.MALE) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(R.string.login_form),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp

        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 25.dp, end = 45.dp)
        ) {
            Text(text = stringResource(R.string.username), color = Color.Black , textAlign = TextAlign.Start)
            OutLineTextFieldMail(onNameChange = { newName ->
                mail = newName
            }, txt = stringResource(R.string.enter_your_mail))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 25.dp, end = 45.dp)
        ) {
            Text(text = stringResource(R.string.password), color = Color.Black, textAlign = TextAlign.Start)
            OutLineTextFieldPass(onNameChange = { newName ->
                pass = newName
            }, txt = stringResource(R.string.enter_your_password))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 75.dp)
        ) {
            Text(text = "favourite hobby ", color = Color.Black , textAlign = TextAlign.Start)
            Column {
                CheckBox(onCheckChanges = { basketballChecked = it }, sportType = "basketball")
                CheckBox(onCheckChanges = { footballChecked = it }, sportType = "Football")
                CheckBox(onCheckChanges = { volleyballChecked = it }, sportType = "volley")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 125.dp)
        ) {
            Text(text = "Gender", color = Color.Black, textAlign = TextAlign.Start)
            GenderSelection(onGenderClicked = { selectedGender = it })

        }

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                    cliked = true
                val loginRequest = LoginRequest(mail , pass)
                viewModel.loginRequest(loginRequest)

            }, colors = ButtonDefaults.buttonColors(blue),
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp)
                .wrapContentSize(align = Alignment.Center)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_now), color = Color.Black)

        }
        if (cliked){
            val arrOFHobbies  = hobbiesMap.filterValues { it }.keys

            CustomToast(message = "mail is $mail \b gender is $selectedGender \nhobbies is $arrOFHobbies" )
        }
        if (state.isLoading){
            CircularProgressIndicator()
        }

    }


    if (state.loginSuccessfully){
        navController.navigate(ScreenRoutes.PostsListScreen.route)
    }

}