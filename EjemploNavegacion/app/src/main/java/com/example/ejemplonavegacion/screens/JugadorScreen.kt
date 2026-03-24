package com.example.ejemplonavegacion.screens

import android.widget.GridLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JugadorScreen(id:String, navegarAtras:()->Unit){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
        modifier =
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            )
        {
            Text("El jugador elegido es: $id", fontSize = 32.sp)
            Spacer(Modifier.height(16.dp))
            Button(onClick = {navegarAtras()}) {
                Text("Atrás")
            }
        }
    }
}