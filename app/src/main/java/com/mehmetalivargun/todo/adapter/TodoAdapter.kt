package com.mehmetalivargun.todo.adapter

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehmetalivargun.todo.databinding.TodoLayoutAdapterBinding
import com.mehmetalivargun.todo.model.Todo

class TodoAdapter :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    fun getItem(position: Int):Todo{
        return differ.currentList[position]
    }
    inner class TodoViewHolder(val binding: TodoLayoutAdapterBinding):RecyclerView.ViewHolder(binding.root)
    private val diffCallBack=object : DiffUtil.ItemCallback<Todo>(){
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem==newItem
        }

    }
    val differ= AsyncListDiffer(this,diffCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(TodoLayoutAdapterBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        Log.e("position",position.toString())
        val todo=differ.currentList[position]
        holder.binding.apply {
            tvTodo.text=todo.todoTitle
        }

        holder.binding.checkBox.apply {
            setOnClickListener {
                holder.binding.apply {
                    if (isChecked){
                        tvTodo.paintFlags=tvTodo.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                    }else{
                        tvTodo.paintFlags=tvTodo.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    }
                }
            }
        }
    }

    override fun getItemCount()=differ.currentList.size




}