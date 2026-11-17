package com.example.lab_1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_1.ui.components.ProjectCard
import com.example.lab_1.ui.components.ProjectHorizontalCard
import com.example.lab_1.ui.components.TaskCard
import com.example.lab_1.model.HorizontalList
import com.example.lab_1.model.Project
import com.example.lab_1.model.Task
import com.example.lab_1.ui.theme.Green
import com.example.lab_1.ui.theme.Red
import com.example.lab_1.ui.viewmodels.TasksViewModel


@Composable
fun TasksScreen(
    modifier: Modifier = Modifier,
    viewModel: TasksViewModel,
    onNavigateToDetails: () -> Unit
) {
    val appList by viewModel.appLiveList.observeAsState(emptyList())
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = viewModel.taskStatus.value ,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(
                items = appList, key = { item ->
                    "${item.id}_${
                        when (item) {
                            is Project -> item.name
                            is Task -> item.title
                            is HorizontalList -> item.hashCode()
                        }
                    }"
                }) { item ->
                when (item) {
                    is Project-> ProjectCard(project = item)
                    is Task -> TaskCard(task = item)
                    is HorizontalList -> HorizontalItem(item)
                }
            }
        }
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

        Button(
            onClick = onNavigateToDetails,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .height(55.dp)
        ) {
            Text("Task Details", fontSize = 16.sp)
        }
    }
}

@Composable
fun HorizontalItem(
    horizontalList: HorizontalList,
    modifier: Modifier = Modifier,
    onProjectClick: (Project) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = horizontalList.projectList,
                key = { project -> "${project.id}_${project.name}" }
            ) { project ->
                ProjectHorizontalCard(
                    project = project,
                    onClick = { onProjectClick(project) }
                )
            }
        }
    }
}