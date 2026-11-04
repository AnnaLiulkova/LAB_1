package com.example.lab_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.lab_1.ui.screens.ProgressScreen
import com.example.lab_1.ui.screens.TasksScreen
import com.example.lab_1.ui.screens.ScheduleScreen
import com.example.lab_1.ui.theme.LAB_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LAB_1Theme {
                LAB_1App()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun LAB_1App() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.SCHEDULE) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label,
                            modifier = Modifier.size(42.dp)
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when(currentDestination){
                AppDestinations.SCHEDULE -> ScheduleScreen(
                    modifier = Modifier.padding(innerPadding),
                )
                AppDestinations.TASKS -> TasksScreen(
                    modifier = Modifier.padding(innerPadding),
                )
                AppDestinations.PROGRESS -> ProgressScreen(
                    modifier = Modifier.padding(innerPadding),
                )
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    SCHEDULE("Schedule", R.drawable.ic_schedule),
    TASKS("Tasks", R.drawable.ic_task),
    PROGRESS("Progress", R.drawable.ic_progress),
}