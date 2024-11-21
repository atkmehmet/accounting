package com.example.accounting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewCorotinues(private val adder:NumberAdder = NumberAdder()):ViewModel() {

var resulState by mutableStateOf("0")
    private set

    fun add(a:String,b:String){
        viewModelScope.launch {
            val result = adder.add(a.toInt(),b.toInt())
            resulState = result.toString()
        }
    }
}