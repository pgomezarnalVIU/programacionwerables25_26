package com.example.clubbasquetpasopaso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.example.clubbasquetpasopaso.domain.data.firebase.datasource.FirestoreProvider
import com.example.clubbasquetpasopaso.domain.data.local.database.AppDatabase
import com.example.clubbasquetpasopaso.presentation.navigation.NavigationWrapper
import com.example.clubbasquetpasopaso.ui.theme.ClubBasquetPasoPasoTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        auth = Firebase.auth
        setContent {
            ClubBasquetPasoPasoTheme {
                val context = LocalContext.current
                val db = AppDatabase.getInstance(context.applicationContext)
                val firestore = FirestoreProvider.instance
                NavigationWrapper(db,auth, firestore)
            }
        }
    }
}

