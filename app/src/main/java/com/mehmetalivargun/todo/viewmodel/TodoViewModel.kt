package com.mehmetalivargun.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mehmetalivargun.todo.model.Todo
import com.mehmetalivargun.todo.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject constructor(private  val todoRepository: TodoRepository):ViewModel(){

    fun insertTodo(todo: Todo)= viewModelScope.launch {
        todoRepository.insertTodo(todo)

    }

    fun deleteTodo(todo:Todo)=viewModelScope.launch {
        todoRepository.deleteTodo(todo)
    }


    val getAllToDos=todoRepository.getAllTodos().asLiveData()
}