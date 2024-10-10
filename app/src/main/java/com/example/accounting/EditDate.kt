package com.example.accounting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDate(
    value:String,
    event:(String)->Unit,
    isEmpty:Boolean,
    keyboardType: KeyboardOptions,
    informText:String,
    isHide:Boolean,
    modifier: Modifier = Modifier
){
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
   // val selectedDate = datePickerState.selectedDateMillis?.let { convertMillisToDate2(it) } ?: ""


    Box(modifier = modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MyConstantClass.paddingValue) // Added padding for layout spacing
        ) {
            BasicTextField(
                value = value,
                onValueChange = {},
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
                    Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically)
                    {

                        if (value.isEmpty()) {
                            Text(
                                text = informText,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier.padding(start = 4.dp) // Added padding for the placeholder
                            )
                        }

                        Box(modifier = Modifier.weight(1f)){

                            innerTextField()
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = null, modifier = Modifier.clickable {
                            showDatePicker = !showDatePicker
                        } )
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


        if (showDatePicker) {
            Popup(
                onDismissRequest = {
                    showDatePicker = false
                    // Update the value with the selected date
                    datePickerState.selectedDateMillis?.let {
                        val selectedDate = convertMillisToDate3(it)
                        event(selectedDate)
                    }
                },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }


}



fun convertMillisToDate3(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}