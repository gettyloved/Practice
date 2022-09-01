package com.ciru.practice


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Tax(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        var text by remember {
            mutableStateOf("")
        }
        TextField(
            value = text,
            onValueChange = {text = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = text)
        Button(onClick = { }) {

        }
    }
}