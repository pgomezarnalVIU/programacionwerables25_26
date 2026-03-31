package com.example.fichajugadorv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fichajugadorv2.components.JugadorPersonalData
import com.example.fichajugadorv2.components.JugadorPersonalStats
import com.example.fichajugadorv2.ui.theme.FichaJugadorV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FichaJugadorV2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Ficha de jugador
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(colorResource(R.color.bg_color))
                    ){
                        //Foto jugador
                        Image(
                            painter = painterResource(id = R.drawable.foto_jugador),
                            contentDescription = "Foto del jugador",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter
                        )

                        //Contenidos
                        //Datos del jugador
                        JugadorPersonalData()
                        //Estadisticas
                        JugadorPersonalStats()
                    }
                }
            }
        }
    }
}

