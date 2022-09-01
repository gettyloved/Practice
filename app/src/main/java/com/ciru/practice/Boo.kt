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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController


@Composable
fun Boo(theViewModel: TheViewModel,navController: NavController){
    val context = LocalContext.current
    val mName = theViewModel._name.collectAsState()
    val mEmail = theViewModel._email.collectAsState()
//    val mSetEmail = { theViewModel.setEmail(it) }
//    val mSetName =
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = mName,
            onValueChange = { value -> theViewModel.setName(value) },
            label = {
                Text(text = "Name")
            },
            modifier = Modifier.padding(10.dp)
        )
//        TextField(
//            value = mEmail,
//            onValueChange = mSetEmail
//        )
        Button(
            onClick = { }) {
            Text(text = "Post")
        }
    }
}