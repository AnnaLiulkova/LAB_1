package com.example.lab_1.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lab_1.ui.navigation.TasksScreen
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class TasksViewModel : ViewModel() {
    var taskStatus = mutableStateOf("Status: Pending")
        private set

    fun completeTask() {
        taskStatus.value = "Status: Completed"
    }

    fun resetTask() {
        taskStatus.value = "Status: Canceled"
    }

    val tasksbackStack: StateFlow<List<TasksScreen>>
        field = MutableStateFlow<List<TasksScreen>>(listOf(TasksScreen.Main))

    fun navigateTo(screen: TasksScreen) {
        tasksbackStack.update { currentStack ->
            currentStack + screen
        }
    }

    fun navigateBack(): Boolean {
        if (tasksbackStack.value.size > 1) {
            tasksbackStack.update { currentStack ->
                currentStack.dropLast(1)
            }
            return true
        }
        return false
    }
}