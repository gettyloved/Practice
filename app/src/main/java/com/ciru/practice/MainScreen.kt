package com.ciru.practice

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList

@Composable
fun MainScreen(){
    val list = remember{ GlassCup().toMutableStateList()}
   Glasses(list = list, onCloseTask = {task -> list.remove(task)})
}

private fun GlassCup() = List(30){i -> Glass(i, "Task # $i")}