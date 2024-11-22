package com.example.accounting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Calculator(a:String,onAChanged:(String)->Unit,
               b:String,onBChanged:(String)->Unit,result:String,
                onButtonClick:()->Unit)
{
Column(modifier = Modifier.padding(16.dp)) {
    OutlinedTextField(value = a, onValueChange = onAChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(text = "a")})

    OutlinedTextField(value = b, onValueChange = onBChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(text = "b")})

    Text(text = result)
    Button(onClick = { onButtonClick }) {
        Text(text="Calculate")
    }
}
}