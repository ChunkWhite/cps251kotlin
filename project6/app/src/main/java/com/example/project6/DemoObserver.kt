package com.example.project6

import android.util.Log
import androidx.lifecycle.*
import com.example.project6.ui.main.MainViewModel
import java.time.LocalTime

class DemoObserver: LifecycleObserver {

    private val LOG_TAG = "DemoObserver"
    private var viewModel= MainViewModel

    private fun getDate(): String {
        return LocalTime.now().toString()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        viewModel.addEvent(
                object{}.javaClass.enclosingMethod?.name
                + " fired at "
                + getDate() + "\n****")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        viewModel.addEvent(
            object{}.javaClass.enclosingMethod?.name
                    + " fired at "
                    + getDate() + "\n****")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        viewModel.addEvent(
            object{}.javaClass.enclosingMethod?.name
                    + " fired at "
                    + getDate() + "\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        viewModel.addEvent(
            object{}.javaClass.enclosingMethod?.name
                    + " fired at "
                    + getDate() + "\n")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        viewModel.addEvent(
            object{}.javaClass.enclosingMethod?.name
                    + " fired at "
                    + getDate() + "\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        viewModel.addEvent(
            object{}.javaClass.enclosingMethod?.name
                    + " fired at "
                    + getDate() + "\n****")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
        var currentState = owner.lifecycle.currentState.name.toString()
        var eventName = event.name.toString()
        Log.i(LOG_TAG, "onAny")
    }
}