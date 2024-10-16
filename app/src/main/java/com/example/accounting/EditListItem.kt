package com.example.accounting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditListItem(edt:Edits){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp))
    {
        Row {
            Text(text = edt.name)
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(text = edt.surName)
            
        }
        Text(text = edt.address)
        Text(text = edt.birthDate)

    }
}