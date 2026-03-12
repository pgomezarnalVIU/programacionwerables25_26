package com.example.fichajugador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fichajugador.components.JugadorCard
import com.example.fichajugador.components.JugadorStats
import com.example.fichajugador.ui.theme.FichaJugadorTheme


data class FichaJugador(
    val nombre: String,
    val categoria: String,
    val genero: String,
    val numero: Int,
    val equipo: String,
    val club: String,
    val puntosUnoPartido: Double,
    val puntosDosPartido: Double,
    val puntosTresPartido: Double,
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FichaJugadorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Ficha de jugador
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(colorResource(R.color.bg_color))
                    ) {
                        // Foto superior ocupando todo el ancho
                        Image(
                            painter = painterResource(id = R.drawable.foto_jugador),
                            contentDescription = "Foto del jugador",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter
                        )
                        //Contenido principal
                        JugadorCard()
                        Spacer(modifier = Modifier.height(16.dp))
                        JugadorStats()
                    }
                }
            }
        }
    }
}


