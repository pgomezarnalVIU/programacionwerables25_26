package com.example.fichajugadorv2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fichajugadorv2.R

@Composable
fun JugadorPersonalStats() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Cabecera
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.stat_head_color))
                    .padding(vertical = 14.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Estadísticas por Partido",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //Estadisticas
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                JugadorStatFila(
                    textoBadge = "1P",
                    colorBadge = R.color.stat_1p_color,
                    label = "Tiros de 1 punto",
                    value = 5.9
                )

                HorizontalDivider(Modifier,
                    DividerDefaults.Thickness,
                    color = colorResource(R.color.divider_color))

                JugadorStatFila(
                    textoBadge = "2P",
                    colorBadge = R.color.stat_2p_color,
                    label = "Tiros de 2 puntos",
                    value = 8.6
                )

                HorizontalDivider(Modifier,
                    DividerDefaults.Thickness,
                    color = colorResource(R.color.divider_color))

                JugadorStatFila(
                    textoBadge = "3P",
                    colorBadge = R.color.stat_3p_color,
                    label = "Tiros de 3 puntos",
                    value = 6.6
                )
            }
        }
    }
}

@Composable
fun JugadorStatFila(textoBadge: String,colorBadge: Int,
                    label: String,
                    value: Double){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .size(54.dp)
                //Introduce un recorte del contenido con la forma que le indiquemos
                //En este caso con la forma de un círculo
                .clip(CircleShape)
                .background(colorResource(colorBadge)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = textoBadge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = label,
            modifier = Modifier.weight(1f),
            color = Color(0xFF111827),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = String.format("%.1f", value),
            color = Color(0xFF111827),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

    }
}