package com.example.accounting

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomMenu(){
    val navController  = rememberNavController()
    Scaffold(bottomBar = {BottomNavigationBar(navController =navController)})
    {innerPadding->

        MainScreen(Modifier.padding(innerPadding))
    }
}
@Composable
fun MainScreen(modifier: Modifier){
    
    Text(text = "Main content", modifier = modifier.padding(16.dp))
}
@Composable
fun BottomNavigationBar(navController: NavController){
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    NavigationBar ( containerColor = MaterialTheme.colorScheme.primary){
val items = listOf(
    
)

    }

}