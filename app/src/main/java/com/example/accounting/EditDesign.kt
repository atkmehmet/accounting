package com.example.accounting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditDesign(
    value:String,
    event:(String)->Unit,
    isEmpty:Boolean,
    keyboardType: KeyboardOptions,
    informText:String,
    isHide:Boolean,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MyConstantClass.paddingValue) // Added padding for layout spacing
        ) {
            BasicTextField(
                value = value,
                onValueChange = { event( it) },
                keyboardOptions = keyboardType,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.background
                    )
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .height(MyConstantClass.heightValue)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(10.dp)
                    ),
                  textStyle = TextStyle(fontSize = MyConstantClass.textSizeValue, color = Color.DarkGray, fontWeight = FontWeight.Bold),

                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                        // Placeholder text if value is empty
                        if (value.isEmpty()) {
                            Text(
                                text = informText,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier.padding(start = 4.dp) // Added padding for the placeholder
                            )
                        }
                        Box(modifier = Modifier.padding(start = 10.dp)){

                          innerTextField()
                        }
                    }
                }
            )
        }
      

        // Error message if input is empty
        if (value.isEmpty() && !isEmpty) {
            Text(
                text = "Please Write Information",
                color = Color.Red,
                style = TextStyle(fontSize = MyConstantClass.textSizeValue),
                modifier = Modifier
                    .padding(
                        top = 40.dp,
                        start = MyConstantClass.paddingValue
                    ) // Adds some space between the error text and the field
                    .align(Alignment.BottomStart) // Aligns the error message to start of the Box
            )
        }
    }


}