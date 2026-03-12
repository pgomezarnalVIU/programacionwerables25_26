package com.example.fichajugador.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fichajugador.R

@Composable
fun JugadorCard(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Carlos Gómez",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.txt_title),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))

            JugadorFila("Categoría: ","Junior")
            HorizontalDivider(Modifier,
                DividerDefaults.Thickness,
                color = colorResource(R.color.divider_color))
            JugadorFila("Numero: ","23")
            HorizontalDivider(Modifier,
                DividerDefaults.Thickness,
                color = colorResource(R.color.divider_color))
            JugadorFila("Equipo: ","Valencia BC Academy")
            HorizontalDivider(Modifier,
                DividerDefaults.Thickness,
                color = colorResource(R.color.divider_color))
            JugadorFila("Club: ","Valencia BC")
        }
    }
}

@Composable
fun JugadorFila(label: String, value:String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = colorResource(R.color.txt_info_label_player),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = value,
            color = colorResource(R.color.txt_info_value_player),
            fontSize = 18.sp
        )
    }
}

