package com.mehmetalivargun.todo.repository

import com.mehmetalivargun.todo.db.TodoDao
import com.mehmetalivargun.todo.model.Todo
import javax.inject.Inject

class TodoRepository
@Inject constructor(private val dao: TodoDao){

    suspend fun  insertTodo(todo: Todo)=dao.insertTodo(todo)
    suspend fun deleteTodo(todo:Todo)=dao.deleteTodo(todo)
    fun getAllTodos()=dao.getAllTodos()
}