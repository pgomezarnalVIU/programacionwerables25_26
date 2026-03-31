package com.example.clubbasquetpasopaso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.example.clubbasquetpasopaso.domain.data.local.database.AppDatabase
import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity
import com.example.clubbasquetpasopaso.presentation.navigation.NavigationWrapper
import com.example.clubbasquetpasopaso.ui.theme.ClubBasquetPasoPasoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClubBasquetPasoPasoTheme {
                val context = LocalContext.current
                val db = AppDatabase.getInstance(context.applicationContext)
                NavigationWrapper(db)
            }
        }
    }
}

