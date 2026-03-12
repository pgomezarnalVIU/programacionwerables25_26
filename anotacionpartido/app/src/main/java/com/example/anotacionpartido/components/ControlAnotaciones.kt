package com.example.anotacionpartido.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.anotacionpartido.R

data class JugadorUi(
    val numero: Int,
    val nombre: String,
    val puntos: Int
)
@Composable
fun ControlAnotacionesScreen() {
    val jugadores = remember {
        mutableStateListOf(
            JugadorUi(4, "García", 8),
            JugadorUi(7, "Pérez", 12),
            JugadorUi(9, "López", 5),
            JugadorUi(11, "Sánchez", 14),
            JugadorUi(12, "Morales", 6),
            JugadorUi(15, "Ramírez", 10),
            JugadorUi(23, "Díaz", 7)
        )
    }
    var selectedIndex by remember { mutableIntStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    fun sumarPuntos(valor: Int) {
        val actual = jugadores[selectedIndex]
        jugadores[selectedIndex] = actual.copy(puntos = actual.puntos + valor)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        //Titulo
        Text(
            text = stringResource(R.string.txt_title),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jugador",
            style = MaterialTheme.typography.labelLarge,
            color = colorResource(R.color.txt_player_color)
        )
        Spacer(modifier = Modifier.height(8.dp))

        JugadorDropdownSimple(
            jugadores = jugadores,
            selectedIndex = selectedIndex,
            onJugadorSeleccionado = { selectedIndex = it }
        )

        //Botones de puntuación
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PuntosButton(
                texto = "+1 pt",
                modifier = Modifier.weight(1f),
                onClick = { sumarPuntos(1) }
            )
            PuntosButton(
                texto = "+2 ptos",
                modifier = Modifier.weight(1f),
                onClick = { sumarPuntos(2) }
            )
            PuntosButton(
                texto = "+3 ptos",
                modifier = Modifier.weight(1f),
                onClick = { sumarPuntos(3) }
            )
        }
        //Listado de jugadores
        Text(
            text = "Jugadores",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelLarge,
            color = Color(0xFF6B7280)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(jugadores) { jugador ->
                JugadorRow(jugador = jugador)
            }
        }
    }
}

@Composable
fun JugadorDropdownSimple(
    jugadores: List<JugadorUi>,
    selectedIndex: Int,
    onJugadorSeleccionado: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = stringResource(
                    R.string.player_format,
                    jugadores[selectedIndex].numero
                ),
                modifier = Modifier.weight(1f),
                color = Color(0xFF111827)
            )

            Icon(
                painter = painterResource(R.drawable.arrow_drop_down),
                contentDescription = null,
                tint = Color(0xFF111827)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(0.92f)
        ) {
            jugadores.forEachIndexed { index, jugador ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(
                                R.string.player_item_format,
                                jugador.numero,
                                jugador.nombre
                            )
                        )
                    },
                    onClick = {
                        onJugadorSeleccionado(index)
                        expanded = false
                    }
                )
            }
        }
    }
}
@Composable
fun PuntosButton(
    texto: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(52.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF111827),
            contentColor = Color.White
        )
    ) {
        Text(
            text = texto,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun JugadorRow(jugador: JugadorUi) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        color = Color(0xFF111827),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "#${jugador.numero}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.size(12.dp))

            Text(
                text = jugador.nombre,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Puntos",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF6B7280)
                )
                Text(
                    text = jugador.puntos.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
