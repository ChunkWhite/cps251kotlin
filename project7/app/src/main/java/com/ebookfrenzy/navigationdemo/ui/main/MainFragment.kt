package com.ebookfrenzy.navigationdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.navigationdemo.R
import androidx.navigation.Navigation

import com.ebookfrenzy.navigationdemo.databinding.MainFragmentBinding

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
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  = MainFragmentDirections.mainToSecond()
            action.setImageId(R.drawable.android_image_1)
            action.setMessage(binding.imageView1.contentDescription.toString())
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  = MainFragmentDirections.mainToSecond()
            action.imageId = R.drawable.android_image_2
            action.message = binding.imageView2.contentDescription.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  = MainFragmentDirections.mainToSecond()
            action.imageId = R.drawable.android_image_3
            action.message = binding.imageView3.contentDescription.toString()
            Navigation.findNavController(it).navigate(action)
        }
//        binding.button.setOnClickListener {
//            val action: MainFragmentDirections.MainToSecond  =
//            MainFragmentDirections.mainToSecond()
//            action.setMessage(binding.imageView1.drawable.toString())
//            action.setImageId(binding.imageView1.id)
//            action.setMessage(binding.userText.text.toString())
//            Navigation.findNavController(it).navigate(action)
        }
    }
