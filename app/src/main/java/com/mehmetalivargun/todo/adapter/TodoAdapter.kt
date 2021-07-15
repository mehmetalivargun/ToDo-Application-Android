package com.mehmetalivargun.todo.adapter

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehmetalivargun.todo.R
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

        val todo=differ.currentList[position]
        holder.binding.apply {
            tvTodo.text=todo.todoTitle
        }


        holder.binding.cardView.setOnClickListener {

            holder.binding.checkBox.apply {
                this.isChecked = !isChecked
                checkTodo(holder,isChecked)
            }
        }

        holder.binding.checkBox.apply {
            setOnClickListener {
               checkTodo(holder,isChecked)
                }
            }
        }


    override fun getItemCount()=differ.currentList.size

    private fun checkTodo(holder: TodoAdapter.TodoViewHolder,isChecked:Boolean) {
        holder.binding.apply {
            if (isChecked) {
                tvTodo.paintFlags = tvTodo.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                tvTodo.setTextColor(Color.parseColor("#FFB1B1B1"))


            } else {
                tvTodo.paintFlags = tvTodo.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                tvTodo.setTextColor(Color.parseColor("#000000"))
            }
        }
    }


}