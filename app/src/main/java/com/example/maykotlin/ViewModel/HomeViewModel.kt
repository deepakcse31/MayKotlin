package com.example.maykotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val _description = MutableLiveData<String>()
    val description: MutableLiveData<String> get() = _description

    fun updateDescription(newDescription: String) {
        _description.value = newDescription
    }

}