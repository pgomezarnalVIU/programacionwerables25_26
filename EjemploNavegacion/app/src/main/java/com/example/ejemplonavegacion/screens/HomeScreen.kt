package com.example.ejemplonavegacion.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navegarAlJugador:(String)->Unit){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(Modifier.padding(innerPadding)) {
            items(30){
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .padding(start=16.dp)
                        .height(50.dp)
                        .fillMaxWidth()
                        .clickable{
                            navegarAlJugador(it.toString())
                        }
                )
                {
                    Text("Soy el jugador #${it}")
                }
            }
        }
    }
}