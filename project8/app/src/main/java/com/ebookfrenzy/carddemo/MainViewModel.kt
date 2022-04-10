package com.ebookfrenzy.carddemo

import androidx.lifecycle.ViewModel
import kotlin.random.Random

private val data = Data.titles.size

class MainViewModel: ViewModel() {
    private val titles = List(data) {
        Random.nextInt(data)
    }

    private val details = List(data) {
        Random.nextInt(data)
    }

    private val images = List(data) {
        Random.nextInt(data)
    }

    fun getTitles() : List<Int> {
        return this.titles
    }
    fun getDetails() : List<Int> {
        return this.details
    }
    fun getImages() : List<Int> {
        return this.images
    }
}