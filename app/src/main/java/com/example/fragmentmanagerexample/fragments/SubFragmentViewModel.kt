package com.example.fragmentmanagerexample.fragments

import android.util.Log
import androidx.lifecycle.ViewModel

class SubFragmentViewModel(str:String) : ViewModel() {
    var headLine = str

    private var _text = ""
    val text : String
        get() = _text

    init {
        Log.d("subfragmentviewModel", "create")
    }

    fun editText(str:CharSequence) {
        _text = str.toString()
    }
}