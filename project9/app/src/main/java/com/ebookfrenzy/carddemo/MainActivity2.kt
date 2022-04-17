package com.ebookfrenzy.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

import com.ebookfrenzy.carddemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val qIntTitle = extras.getInt("Title")
        binding.titleText.text = Data.titles[qIntTitle]

        val qIntDetail = extras.getInt("Detail")
        binding.detailText.text = Data.details[qIntDetail]

        val qIntImg = extras.getInt("Image")
        binding.img.setImageResource(Data.images[qIntImg])
    }
}