package com.example.lab_1.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface TasksScreen : NavKey {
    @Serializable
    data object Main : TasksScreen

    @Serializable
    data object Details : TasksScreen

    @Serializable
    data object Edit : TasksScreen
}
