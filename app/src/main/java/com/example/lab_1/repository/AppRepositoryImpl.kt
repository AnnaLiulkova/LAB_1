package com.example.lab_1.repository

import com.example.lab_1.model.HorizontalList
import com.example.lab_1.model.MyListable
import com.example.lab_1.model.Priority
import com.example.lab_1.model.Project
import com.example.lab_1.model.Task
import com.example.lab_1.model.TaskStatus

class AppRepositoryImpl : AppRepository {

    val myProjectList: List<Project> = listOf(
        Project(name = "Lab works", deadline = "30/11/2026", id = 1),
        Project(name = "Coursework",     deadline = "15/12/2026", id = 2),
        Project(name = "English",    deadline = "20/11/2026", id = 3),
        Project(name = "Exam preparation", deadline = "10/01/2027", id = 4),
    )

    val myAppList: List<MyListable> = listOf(
        HorizontalList(myProjectList, id = 100),
        Task(
            title = "Task without project",
            priority = Priority.Low,
            deadline = "13/11/2026",
            status = TaskStatus.Pending,
            project = null,
            id = 0
        ),
        Task("Complete lab work", Priority.High,   "20/11/2026", TaskStatus.Pending,   myProjectList[0], 1),
        Task("Prepare report",          Priority.Medium, "22/11/2026", TaskStatus.Completed, myProjectList[0], 2),
        Task("Choose a topic",   Priority.High,   "10/11/2026", TaskStatus.Completed, myProjectList[1], 3),
        myProjectList[2],
        Task("Learn words",        Priority.Low,    "20/11/2026", TaskStatus.Pending,   myProjectList[2], 4),
        Task("Write introduction",         Priority.High,   "01/12/2026", TaskStatus.Pending,   myProjectList[1], 5),
        Task("Prepare presentation", Priority.Medium, "05/12/2026", TaskStatus.Canceled, myProjectList[1], 6),
        Task("Review material",   Priority.High,   "05/01/2027", TaskStatus.Pending,   myProjectList[3], 7),
        Task("Review lecture",       Priority.Medium, "07/01/2027", TaskStatus.Pending,   myProjectList[3], 8),
        myProjectList[3],
        Task("Submit lab work",   Priority.High,   "07/11/2026", TaskStatus.Completed, myProjectList[0], 11),
        Task("Read article",       Priority.Low,    "28/11/2026", TaskStatus.Pending,   myProjectList[2], 12),
        myProjectList[0],
        Task("Prepare questions",    Priority.Medium, "29/11/2026", TaskStatus.Pending,   myProjectList[1], 13),
    )

    override fun getList(): List<MyListable> = myAppList
}