package com.example.accounting

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var label:String,var icon:ImageVector) {


    object Home: BottomNavItem("Home",Icons.Filled.Home)
    object Profile: BottomNavItem("Profile",Icons.Filled.Home)
    object Settings: BottomNavItem("Settings",Icons.Filled.Home)
}