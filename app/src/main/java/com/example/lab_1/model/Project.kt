package com.example.lab_1.model

data class Project(
    val name: String,
    val deadline: String,
    override val id: Int
) : MyListable
