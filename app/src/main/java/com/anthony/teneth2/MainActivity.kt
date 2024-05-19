package com.anthony.teneth2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

import com.anthony.teneth2.ui.theme.Teneth2Theme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

import androidx.compose.material.icons.sharp.PlayArrow
import com.anthony.teneth2.screens.HomeScreen
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

                )
                val selectedItem = remember { mutableStateOf(items.first()) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
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





