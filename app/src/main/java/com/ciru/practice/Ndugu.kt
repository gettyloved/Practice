package com.ciru.practice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Ndungu(modifier: Modifier = Modifier, theViewModel: TheViewModel){
    StateLess(count = theViewModel.count, onIncrement = { theViewModel.count++ })
}

@Composable
private fun StateLess(count: Int, onIncrement:() -> Unit) {

    Column(
        Modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text(text = "you have drunk ${count} glasses of water")
        }

        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Add One")
        }
    }
}








