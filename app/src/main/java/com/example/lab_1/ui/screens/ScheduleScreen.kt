package com.example.lab_1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScheduleScreen(modifier: Modifier = Modifier) {
    var labelText by remember { mutableStateOf("Schedule: empty") }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = labelText,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                labelText = "Schedule updated"
            },
            shape = RectangleShape,
            modifier = Modifier.size(width = 220.dp, height = 70.dp)
        ) {
            Text(
                text = "Save",
                fontSize = 18.sp,
            )
        }
    }
}