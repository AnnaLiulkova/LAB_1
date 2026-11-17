package com.example.lab_1.model

enum class Priority { Low, Medium, High }

data class Task(
    val title: String,
    val priority: Priority,
    val deadline: String,
    val status: TaskStatus,
    val project: Project?,
    override val id: Int
) : MyListable