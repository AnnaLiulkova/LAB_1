package com.example.lab_1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab_1.ui.theme.Green
import com.example.lab_1.ui.theme.Red
import com.example.lab_1.ui.viewmodels.TasksViewModel

@Composable
fun TasksScreen(
    modifier: Modifier = Modifier,
    viewModel: TasksViewModel = viewModel()
) {
//    var taskStatus by rememberSaveable { mutableStateOf("Статус: Очікує виконання")}
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = viewModel.taskStatus.value ,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    viewModel.completeTask()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green),
                modifier = Modifier.weight(1f).height(55.dp)
            ) {
                Text("Done", fontSize = 16.sp)
            }

            Button(
                onClick = {
                    viewModel.resetTask()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red),
                modifier = Modifier.weight(1f).height(55.dp)
            ) {
                Text("Cancel", fontSize = 16.sp)
            }
        }
    }
}