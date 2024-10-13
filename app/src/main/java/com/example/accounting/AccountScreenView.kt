package com.example.accounting

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class AccountScreenView:ViewModel() {
 private   var _state by mutableStateOf(Edits())
   val state :Edits
       get () =_state


    fun updateName(newName:String){
        _state = _state.copy(
            name = newName
        )
    }


    fun updateSurName(surName:String){
        _state = _state.copy(
            name = surName
        )
    }

    fun updateAdress(adress:String){
        _state = _state.copy(
            name = adress
        )
    }



    fun updateBirthDate(date:String){
        _state = _state.copy(
            birthDate = date
        )
    }


}