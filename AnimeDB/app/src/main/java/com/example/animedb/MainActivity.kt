package com.example.animedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animedb.data.animes
import com.example.animedb.presentation.components.AnimeCard
import com.example.animedb.ui.theme.AnimeDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        items(animes){anime ->
                                AnimeCard(anime)
                                Spacer(modifier = Modifier.height(10.dp))
                        }
                        /*
                        animes.forEach { anime ->
                            item{
                                AnimeCard(anime)
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }*/
                    }
                }
            }
        }
    }
}

