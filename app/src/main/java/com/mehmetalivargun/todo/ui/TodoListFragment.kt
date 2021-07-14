package com.mehmetalivargun.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mehmetalivargun.todo.R
import com.mehmetalivargun.todo.databinding.FragmentTodoListBinding


class TodoListFragment : Fragment(R.layout.fragment_todo_list) {


    private var _binding: FragmentTodoListBinding? = null
    private val binding get() =_binding!!


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
        val direction=TodoListFragmentDirections.actionTodoListFragmentToAddTodoFragment()
        binding.fabAddToDo.setOnClickListener {
            view.findNavController().navigate(direction)
        }

    }


}