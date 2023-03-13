package com.example.currency_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // remember navController so it does not
            // get recreated on recomposition
            val navController = rememberNavController()

            Surface(color = Color.White) {
                // Scaffold Component
                Scaffold(
                    // Bottom navigation
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }, content = { it ->
                        // Navhost: where screens are placed
                        NavHostContainer(navController = navController)
                    }
                )
            }
        }
    }
}