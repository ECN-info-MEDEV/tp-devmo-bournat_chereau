package com.example.piratebay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.TopAppBar
import com.example.piratebay.ui.theme.PirateBayTheme


class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            PirateBayTheme {
                CupcakeApp()
            }
        }
    }
}