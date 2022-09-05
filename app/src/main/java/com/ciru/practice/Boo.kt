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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = theViewModel._email,
            onValueChange = { theViewModel._email = it },
            label = {
                Text(text = "Email")
            },
            modifier = Modifier.padding(10.dp)
        )

        TextField(
            value = theViewModel._username,
            onValueChange = { theViewModel._username = it },
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
                theViewModel.setCapturedEmail(theViewModel._email)
                theViewModel.setCapturedEmail(theViewModel._username)
                theViewModel.login(email = theViewModel._email, userName = theViewModel._username)
                navController.navigate(route = MainContent.Bae.route)
            }) {
            when(val p = stateProject){
                is Loading->"loading"
                is Error->p.errorMessage
                is Success->p.email
                is Success -> p.username
                else-> "Post Something"
            }
            Text(text = "Post")
        }
    }
}