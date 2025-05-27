package com.example.maykotlin.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val _description = MutableLiveData<String>()
    val description: MutableLiveData<String> get() = _description

    fun updateDescription(newDescription: String) {
        _description.value = newDescription
    }
    init {
        operation()
    }
    fun operation(){
        GlobalScope.launch(Dispatchers.IO) {
            doWork()
        }
    }

    suspend fun doWork() {
        // Simulate some work
        Log.e("coroutine","doWork")
        delay(2000)
    }
}