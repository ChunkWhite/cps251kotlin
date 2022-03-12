package com.example.project4.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var namesList = ""
    private var namesText = ""

    fun setName(value: String) {
        this.namesText = value
        this.namesList += "\n$value"
    }

    fun getName(): String {
        return namesList
    }
}