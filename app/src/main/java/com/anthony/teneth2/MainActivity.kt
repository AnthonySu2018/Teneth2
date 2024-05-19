package com.anthony.teneth2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

import com.anthony.teneth2.ui.theme.Teneth2Theme

import androidx.compose.material.icons.filled.Home



import androidx.compose.material.icons.sharp.PlayArrow

import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons

import com.anthony.teneth2.screens.HomeScreen
import com.anthony.teneth2.screens.ProductScreen

import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import com.anthony.teneth2.screens.SearchScreen
import com.anthony.teneth2.screens.SettingsScreen


import com.anthony.teneth2.screens.VideoScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teneth2Theme {
                val items = listOf(
                    NavigationItem("Home", Icons.Filled.Home, { HomeScreen() }),
                    NavigationItem("Video", Icons.Sharp.PlayArrow, { VideoScreen() }),
                    NavigationItem("Product", Icons.Filled.List, { ProductScreen() }),
                    NavigationItem("Search", Icons.Default.Search, { SearchScreen() }),
                    NavigationItem("Settings", Icons.Filled.Settings, { SettingsScreen() }),



                    )
                val selectedItem = remember { mutableStateOf(items.first()) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("苏琼亮的面试Demo App") },)},
                    bottomBar = {
                        BottomNavigation {
                            items.forEach { item ->
                                BottomNavigationItem(
                                    icon = { Icon(item.icon, contentDescription = item.label) },
                                    label = { Text(item.label) },
                                    selected = item == selectedItem.value,
                                    onClick = { selectedItem.value = item }
                                )
                            }
                        }
                    }
                ) {
                    selectedItem.value.screen()
                }
            }
        }
    }
}

data class NavigationItem(val label: String, val icon: ImageVector, val screen: @Composable () -> Unit)





