package com.example.lab_1.repository

import com.example.lab_1.model.MyListable

interface AppRepository {
    fun getList(): List<MyListable>
}