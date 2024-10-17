package com.example.accounting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun AccountScreen(view: AccountScreenView){

    val editList by view.listItems.collectAsState()
    val focusRequester1 = remember { FocusRequester() }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        
        EditDesign(value = view.state.name,
            event ={view.updateName(newName = it) } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Your Name" ,isHide = false,focusRequester1)


        EditDesign(value = view.state.surName,
            event ={view.updateSurName( it) } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Your SurName", isHide = false)

        EditDesign(value = view.state.address,
            event ={view.updateAdress(it) } ,
            isEmpty = false ,
            keyboardType =  KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Your Address", isHide = false)

        //DatePickerDocked()
        //DatePickerDocked2()
        EditDate(value = view.state.birthDate, event = {view.updateBirthDate(date = it)}, isEmpty =false , keyboardType = KeyboardOptions(keyboardType = KeyboardType.Text),
            informText = "Please Choose Birth Date", isHide = false)

        Button(onClick = { view.addList()
        focusRequester1.requestFocus()
        }) {

            Text(text = "Save User")
        }
        LazyColumn {
            items(editList.size){edit->

                    EditListItem(edt = editList.get(edit))
            }
        }
    }
}