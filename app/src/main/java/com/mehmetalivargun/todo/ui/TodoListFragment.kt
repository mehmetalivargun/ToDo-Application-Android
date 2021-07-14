package com.mehmetalivargun.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehmetalivargun.todo.R
import com.mehmetalivargun.todo.adapter.TodoAdapter
import com.mehmetalivargun.todo.databinding.FragmentTodoListBinding
import com.mehmetalivargun.todo.model.Todo
import com.mehmetalivargun.todo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment(R.layout.fragment_todo_list) {


    private var _binding: FragmentTodoListBinding? = null
    private val binding get() =_binding!!
    private val viewModel: TodoViewModel by viewModels()
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentTodoListBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        val direction=TodoListFragmentDirections.actionTodoListFragmentToAddTodoFragment()
        binding.fabAddToDo.setOnClickListener {
            view.findNavController().navigate(direction)
        }

    }

    private fun setupRecycler() {
        todoAdapter= TodoAdapter()
        binding.todoList.apply {
            adapter=todoAdapter
            layoutManager=LinearLayoutManager(activity)
            setHasFixedSize(true)
        }

        viewModel.getAllToDos.observe(viewLifecycleOwner,{listTodo->
            updateUI(listTodo)
            todoAdapter.differ.submitList(listTodo)
        })


}

    private fun updateUI(listTodo: List<Todo>) {
        if(listTodo.isNotEmpty()){
            binding.todoList.visibility=View.VISIBLE
            binding.cardView.visibility=View.GONE
        }else{
            binding.todoList.visibility=View.GONE
            binding.cardView.visibility=View.VISIBLE
        }
    }

    }
