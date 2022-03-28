package com.example.project6.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainViewModel() : ViewModel() {

    companion object {
    var event = ""
    var eventText: MutableLiveData<String> = MutableLiveData()

    fun addEvent(value: String) {
                    this.event += "\n" + value
                    eventText.value = event
        }
    }
    fun getEvent(): MutableLiveData<String> {
        return eventText
    }
}