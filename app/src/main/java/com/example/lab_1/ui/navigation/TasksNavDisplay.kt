package com.example.lab_1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.lab_1.ui.screens.TasksDetailsSubScreen
import com.example.lab_1.ui.screens.TasksEditSubScreen
import com.example.lab_1.ui.screens.TasksScreen
import com.example.lab_1.ui.viewmodels.TasksViewModel

@Composable
fun TasksNavDisplay(modifier: Modifier, viewModel: TasksViewModel = viewModel()) {

    val backStack by viewModel.tasksbackStack.collectAsState()

    NavDisplay(
        backStack = backStack,
        onBack = { viewModel.navigateBack() },
        entryProvider = entryProvider {
            entry<TasksScreen.Main> {
                TasksScreen(
                    modifier = modifier,
                    viewModel = viewModel,
                    onNavigateToDetails = { viewModel.navigateTo(TasksScreen.Details) }
                )
            }

            entry<TasksScreen.Details> {
                TasksDetailsSubScreen(
                    onBackClick = { viewModel.navigateBack() },
                    onNavigateToEdit = { viewModel.navigateTo(TasksScreen.Edit) }
                )
            }

            entry<TasksScreen.Edit> {
                TasksEditSubScreen(
                    onBackClick = { viewModel.navigateBack() }
                )
            }
        }
    )
}