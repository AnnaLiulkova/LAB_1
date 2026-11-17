package com.example.lab_1.model

data class HorizontalList(
    val projectList: List<Project>,
    override val id: Int
) : MyListable