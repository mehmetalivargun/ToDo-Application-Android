package com.mehmetalivargun.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mehmetalivargun.todo.R
import com.mehmetalivargun.todo.databinding.FragmentAddTodoBinding
import com.mehmetalivargun.todo.model.Todo
import com.mehmetalivargun.todo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.activityViewModels
@AndroidEntryPoint
class AddTodoFragment : Fragment(R.layout.fragment_add_todo) {

    private var _binding: FragmentAddTodoBinding? = null
    private val binding get() =_binding!!
    private val viewModel:TodoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentAddTodoBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val direction=AddTodoFragmentDirections.actionAddTodoFragmentToTodoListFragment()
        binding.btnCancel.setOnClickListener {
            view.findNavController().navigate(direction)
        }
        binding.btnSave.setOnClickListener {mView->
            saveTodo(mView)
        }

    }

    private fun saveTodo(mView: View) {
        val direction=AddTodoFragmentDirections.actionAddTodoFragmentToTodoListFragment()
        val todoName=binding.etTodoTitle.text.toString()
        Toast.makeText(activity, todoName, Toast.LENGTH_SHORT).show()
        if(todoName.isNotEmpty()){
            val todo=Todo(0,todoName)
            viewModel.insertTodo(todo)
            Snackbar.make(mView,"ToDo added ",Snackbar.LENGTH_SHORT).show()
            mView.findNavController().navigate(direction)
        }
        else{
            Toast.makeText(activity, "Todo Title Can Not Be Empty", Toast.LENGTH_SHORT).show()
        }

    }


}