package com.example.project6.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project6.databinding.MainFragmentBinding

import androidx.lifecycle.Observer
import com.example.project6.DemoObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
     lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            // TODO: Use the ViewModel
            // demoOwner = DemoOwner()
            // demoOwner.startOwner()
            // demoOwner.stopOwner()
//             binding.setVariable(myViewModel, viewModel)
             lifecycle.addObserver(DemoObserver())
            val resultObserver = Observer<String> {
                result -> binding.message.text = result
            }
            viewModel.getEvent().observe(viewLifecycleOwner, resultObserver)

        }
    }
