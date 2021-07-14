package com.mehmetalivargun.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoApp")
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val todoTitle:String
        )
