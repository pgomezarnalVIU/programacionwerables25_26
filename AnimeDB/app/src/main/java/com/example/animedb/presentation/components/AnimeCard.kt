package com.example.animedb.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animedb.data.Anime

@Composable
fun AnimeCard(anime: Anime){
    Column(Modifier.padding(10.dp)) {
        Text("id: ${anime.id.toString()}")
        Text("Titulo: ${anime.titulo}")
        Text("Creador: ${anime.creador}")
        Text("Año creación: ${anime.anyo}")
    }
}