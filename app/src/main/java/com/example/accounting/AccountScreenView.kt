package com.example.accounting

import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class AccountScreenView:ViewModel() {
 private   var _state by mutableStateOf(Edits())
 private   var list = MutableStateFlow(emptyList<Edits>())
    val listItems = list.asStateFlow()

   val state :Edits
       get () =_state


    fun updateName(newName:String){
        _state = _state.copy(
            name = newName
        )
    }
    fun updateSurName(surName:String){
        _state = _state.copy(
            surName = surName
        )
    }
    fun updateAdress(adress:String){
        _state = _state.copy(
            address = adress
        )
    }
    fun updateBirthDate(date:String){
        _state = _state.copy(
            birthDate = date
        )
    }

    fun addList(){
        val edt = Edits(
                    name    = state.name,
                    surName = state.surName,
                    address = state.address,
                    birthDate = state.birthDate
                )


        list.value += edt
    }


}