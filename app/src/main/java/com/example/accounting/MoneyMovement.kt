package com.example.accounting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun MoneyMovement (){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {




        EditDesign(value = "",
            event ={"" } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Choose Customer" ,isHide = true)


        EditDesign(value = "",
            event ={ } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Number),
            informText = "Write Money", isHide = true)

        EditDesign(value = "",
            event ={ } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Your  Notes", isHide = false)

        //DatePickerDocked()
        //DatePickerDocked2()
        EditDate(value = "", event = {}, isEmpty =false , keyboardType = KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Choose  Date", isHide = true)


    }
}