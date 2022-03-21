package com.example.project5.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var namesList: MutableLiveData<String> = MutableLiveData()
    var namesText: MutableLiveData<String> = MutableLiveData()

    fun addName() {
        namesText.let {
            if (!it.value.isNullOrBlank()) {
                if (namesList.value == null) {
                    namesList.value = it.value
                } else {
                    namesList.value += "\n" + it.value
                }
            }
            it.setValue(null)
        }
    }
}