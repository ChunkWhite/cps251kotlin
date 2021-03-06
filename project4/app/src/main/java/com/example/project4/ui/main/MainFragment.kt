package com.example.project4.ui.main

import androidx.lifecycle.ViewModelProvider
import com.example.project4.databinding.MainFragmentBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project4.R


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        binding.displayNames.text = viewModel.getName()

        binding.button.setOnClickListener {
        if (binding.editTextName.text.isNotEmpty()) {
            viewModel.setName(binding.editTextName.text.toString())
            viewModel.getName().also { binding.displayNames.text = it }

        } else {
            binding.displayNames.text = "No Value"
        }
    }
    }
}