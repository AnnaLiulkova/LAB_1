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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_1.ui.theme.Green
import com.example.lab_1.ui.theme.Pink80
import com.example.lab_1.ui.theme.White

@Composable
fun ProgressScreen(modifier: Modifier = Modifier) {
    var progressText by rememberSaveable { mutableStateOf("Progress: 50%") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = progressText,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Button(
            onClick = {
                progressText = "Progress: 100%"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = White
            ),
            modifier = Modifier.size(width = 220.dp, height = 50.dp)
        ) {
            Text(
                text = "Update schedule",
                fontSize = 18.sp,
            )
        }
    }
}