package com.example.fragmentmanagerexample.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SubFragmentViewModelFactory(private val str : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SubFragmentViewModel::class.java)) {
            return SubFragmentViewModel(str) as T
        }
        throw IllegalArgumentException("Unknown_class")
    }


}