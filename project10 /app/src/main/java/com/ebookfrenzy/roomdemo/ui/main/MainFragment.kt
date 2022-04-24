package com.ebookfrenzy.roomdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.roomdemo.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.roomdemo.Product
import androidx.fragment.app.viewModels

import java.util.*

import com.ebookfrenzy.roomdemo.databinding.MainFragmentBinding
import com.google.android.material.snackbar.Snackbar

interface imgDeleteClickListener {
    fun onImgDeleteClick(product: Product)
}

class MainFragment : Fragment(), imgDeleteClickListener {

    private var adapter: ProductListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
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
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()

            if (name != "" && quantity != "") {
                val product = Product(name, quantity)
                viewModel.insertProduct(product)
                clearFields()

            } else {
               Snackbar.make(requireView(),"You must enter a name and phone number",Snackbar.LENGTH_LONG)
                   .setAction("Action", null)
                   .show()
            }
        }

        binding.findButton.setOnClickListener { viewModel.findProduct(binding.productName.text.toString()) }


       binding.ascButton.setOnClickListener{
           viewModel.getAllProductsAsc()
           clearFields()
           viewModel.getAllProducts()?.observe(viewLifecycleOwner, Observer { products ->
               products?.let  {
                   adapter?.setProductList(it)
               }
           })
       }
        binding.descButton.setOnClickListener{
            viewModel.getAllProductsDesc()
            clearFields()
            viewModel.getAllProducts()?.observe(viewLifecycleOwner, Observer { products ->
                products?.let  {
                    adapter?.setProductList(it)
                }
            })
        }

    }

    private fun observerSetup() {

        viewModel.getAllProducts()?.observe(viewLifecycleOwner, Observer { products ->
            products?.let  {
                adapter?.setProductList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { products ->

            products?.let {
                if (binding.productName.text.toString() == ""){
                    Snackbar.make(requireView(),"You must enter a name",Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                    viewModel.getAllProducts()?.observe(viewLifecycleOwner, Observer { products ->
                        products?.let  {
                            adapter?.setProductList(it)
                        }
                    })
                } else if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.productName.setText(it[0].productName)
                    binding.productQuantity.setText(it[0].quantity)
                    adapter?.setProductList(it)
                }
                else {
                    Snackbar.make(requireView(),"There are no contacts that match your search",Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                }
            }

        })

    }

    private fun recyclerSetup() {
        adapter = ProductListAdapter(this)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }

    override fun onImgDeleteClick(product: Product) {
       viewModel.deleteProduct(product.id)
    }
}