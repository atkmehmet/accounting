package com.example.accounting

import androidx.compose.ui.focus.FocusRequester

data class Edits(
    val name:String                      = "",
    val surName :String                  = "",
    val address:String                   = "",
    val birthDate:String                 = "",
    val focusRequester :FocusRequester   = FocusRequester(),
    val isFocused      : Boolean         = false
)
