package com.ciru.practice

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Glasses(
    list: List<Glass>,
    onCloseTask:(Glass) -> Unit
){
    LazyColumn(){
        items(items = list, key = {task -> task.ID}){
            task -> Glasss(taskName = task.label, onClose ={onCloseTask(task)} )
        }
    }
}

@Composable
fun Glasss(taskName: String, onClose: () -> Unit){

    var checkedState by rememberSaveable{ mutableStateOf(false) }

    GlassesCard(
        checked = checkedState,
        taskName = taskName,
        onCheckedChange = {newValue -> checkedState = newValue},
        onClose = onClose
    )
}

@Composable
fun GlassesCard(
    checked: Boolean,
    taskName:String,
    onCheckedChange:(Boolean) -> Unit,
    onClose:() -> Unit
) {
    Card(
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = taskName)

            Checkbox(checked = checked, onCheckedChange = onCheckedChange)

            IconButton(onClick = onClose) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                }
        }
    }
}



