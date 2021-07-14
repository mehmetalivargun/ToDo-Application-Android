package com.mehmetalivargun.todo.db

import androidx.room.*
import com.mehmetalivargun.todo.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)
    @Delete
    suspend fun deleteTodo(todo: Todo)



    @Query("SELECT * FROM TODOAPP ORDER BY id ")
    fun getAllTodos(): Flow<List<Todo>>
}