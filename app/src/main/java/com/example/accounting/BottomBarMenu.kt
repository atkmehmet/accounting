package com.example.accounting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomMenu(){
    val navController  = rememberNavController()
    Scaffold(bottomBar = {BottomNavigationBar(navController =navController)})
    {innerPadding->

        NavigationHost(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}
@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
      val view = AccountScreenView()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { AccountScreen(view = view) }
        composable("money") { ProfilePage() }
        composable("settings") { SettingsPage() }
    }
}

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to the Home Page", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun ProfilePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to the Profile Page", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun SettingsPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to the Settings Page", style = MaterialTheme.typography.headlineMedium)
    }
}



@Composable
fun BottomNavigationBar(navController: NavController){
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    NavigationBar ( containerColor = MaterialTheme.colorScheme.primary){
val items = listOf(
    BottomNavItem.Home,
    BottomNavItem.Profile,
    BottomNavItem.Settings
)
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label) },
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    when (index) {
                        0 -> navController.navigate("home")
                        1 -> navController.navigate("money")
                        2 -> navController.navigate("settings")
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.LightGray
                )
            )
        }
    }

    }

