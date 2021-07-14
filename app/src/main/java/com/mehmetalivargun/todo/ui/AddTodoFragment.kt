package com.mehmetalivargun.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mehmetalivargun.todo.R
import com.mehmetalivargun.todo.databinding.FragmentAddTodoBinding
import com.mehmetalivargun.todo.databinding.FragmentTodoListBinding

class AddTodoFragment : Fragment(R.layout.fragment_add_todo) {

    private var _binding: FragmentAddTodoBinding? = null
    private val binding get() =_binding!!

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

    }


}