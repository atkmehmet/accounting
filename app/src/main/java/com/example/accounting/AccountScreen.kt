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
fun AccountScreen(view: AccountScreenView){

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        
        EditDesign(value = view.state.name,
            event ={view.updateName(newName = it) } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Your Name", isHide = false)
        //DatePickerDocked()
        //DatePickerDocked2()
        EditDate(value = view.state.birthDate, event = {view.updateBirthDate(date = it)}, isEmpty =false , keyboardType = KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Choose Birth Date", isHide = false)
    }
}