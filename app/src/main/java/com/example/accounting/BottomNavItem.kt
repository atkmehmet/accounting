package com.example.accounting

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var label:String,var icon:ImageVector) {


    object Home: BottomNavItem("Home",Icons.Filled.Home)
    object Profile: BottomNavItem("Money",Icons.Filled.ShoppingCart)
    object Settings: BottomNavItem("Settings",Icons.Filled.Settings)
}