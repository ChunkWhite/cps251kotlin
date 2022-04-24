package com.ebookfrenzy.roomdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.roomdemo.Product
import com.ebookfrenzy.roomdemo.R
import com.google.android.material.snackbar.Snackbar

class ProductListAdapter(imgDeleteClickListener: imgDeleteClickListener) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var productList: List<Product>? = null
    private var imgDeleteListen = imgDeleteClickListener

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
        val itemDetail = holder.itemDetail

        productList.let {
            item.text = it!![listPosition].productName
            itemDetail.text = it!![listPosition].quantity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_layout, parent, false)
        return ViewHolder(view,imgDeleteListen)
    }


    fun setProductList(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (productList == null) 0 else productList!!.size
    }

    inner class ViewHolder(itemView: View, imgDeleteClickListen: imgDeleteClickListener) : RecyclerView.ViewHolder(itemView) {

        var item: TextView
        var itemDetail: TextView
        var itemImage: ImageView

        init {
            item = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            itemImage = itemView.findViewById(R.id.itemImage)

            itemImage.setOnClickListener {
                var position: Int = getAdapterPosition()
                val product: Product? = productList?.get(position)
                imgDeleteListen.onImgDeleteClick(product!!)

            }
        }

    }
}