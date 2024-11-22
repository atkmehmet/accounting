package com.example.accounting

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun Screen(viewModel:ViewCorotinues = viewModel()){

    var a by remember {
        mutableStateOf("")
    }
    var b by remember {
        mutableStateOf("")
    }

    Calculator(a = a, onAChanged = {a = it}, b =b , onBChanged ={b = it} , result = viewModel.resulState ) {
        viewModel.add(a,b)
    }

}