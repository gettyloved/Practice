package com.ciru.practice


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun Boo(theViewModel: TheViewModel,navController: NavController){
        val stateProject by theViewModel.stateProject.collectAsState()
        var email by mutableStateOf("")
        var username by mutableStateOf("")
        var statusChange by mutableStateOf("Post something ") // start with an empty status also wrap it in remember{} if you want the value held by the variable to survive configuration change
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email//theViewModel._email,
            onValueChange = { email = it },
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.padding(10.dp)
        )

        TextField(
            value = username//theViewModel._username,
            onValueChange = { username = it },
            label = {
                Text(text = "UserName")
            },
            modifier = Modifier.padding(10.dp)
        )

        TextField(
            value = theViewModel._password,
            onValueChange = { theViewModel._password = it },
            label = {
                Text(text = "Password")
            },
            modifier = Modifier.padding(10.dp)
        )

        Button(
            onClick = {
                // theViewModel.setCapturedEmail(theViewModel._email)
               //  theViewModel.setCapturedEmail(theViewModel._username)
                passDataToViewModel(theViewModel, email, username)
                theViewModel.login()
                statusChange = updateState(stateProject)
                // I don't think this is relevant 
                //theViewModel.login(email = theViewModel._email, userName = theViewModel._username)
                navigateToMainScreen(navController)
               // navController.navigate(route = MainContent.Bae.route)
            }) {
               
//             when(val p = stateProject){
//                 is Loading->"loading"
//                 is Error->p.errorMessage
//                 is Success->p.email
//                 is Success -> p.username
//                 else-> "Post Something"
//             }
            Text(text = statusChange)
        }
    }
}
private fun updateState(stateProject:LoginState)=when(stateProject){
 is Loading->"loading message"
 is Error->stateProject.errorMessage
 is Success->"${stateProject.email}, ${stateProject.username}    
}
private fun navigateToMainScreen(navController) = navController.navigate(route=MainContent.Bae.route)
private fun passDataToViewModel(viewModel:ViewModel,email:String,username:String){
    viewModel.setCapturedEmail(email)
    viewModel.setCapturedUserName(username)
}
