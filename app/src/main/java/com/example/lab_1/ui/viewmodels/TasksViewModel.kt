package com.example.lab_1.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TasksViewModel : ViewModel() {
    var taskStatus = mutableStateOf("Status: Pending")
        private set

    fun completeTask() {
        taskStatus.value = "Status: Completed"
    }

    fun resetTask() {
        taskStatus.value = "Status: Canceled"
    }
}