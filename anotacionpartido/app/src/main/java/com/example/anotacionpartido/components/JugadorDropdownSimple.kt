package com.example.anotacionpartido.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.anotacionpartido.R


@Composable
fun JugadorDropdownSimple(
    jugadores: List<JugadorUi>,
    selectedIndex: Int,
    onJugadorSeleccionado: (Int) -> Unit
) {
    //Ponemos el DropDown en comprimido
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        //OutLinedButton
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "#${jugadores[selectedIndex].numero}",
                modifier = Modifier.weight(1f),
                color = Color(0xFF111827)
            )

            Icon(
                painter = painterResource(R.drawable.arrow_drop_down),
                contentDescription = null,
                tint = Color(0xFF111827),
                modifier = Modifier.size(24.dp)
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
                            text = "#${jugador.numero} - ${jugador.nombre}"
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