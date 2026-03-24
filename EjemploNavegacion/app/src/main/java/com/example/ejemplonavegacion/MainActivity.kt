package com.example.ejemplonavegacion

import com.example.ejemplonavegacion.navigation.NavigationWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ejemplonavegacion.ui.theme.EjemploNavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploNavegacionTheme {
                NavigationWrapper()
            }
        }
    }
}