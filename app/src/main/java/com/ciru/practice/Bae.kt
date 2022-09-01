package com.ciru.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Bae(theViewModel: TheViewModel,navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "${theViewModel.name}", fontWeight = FontWeight.Bold, fontSize = 60.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "${theViewModel.email}", fontWeight = FontWeight.Bold, fontSize = 60.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.background(Color.Red).size(200.dp)) {
            
        }
    }
}