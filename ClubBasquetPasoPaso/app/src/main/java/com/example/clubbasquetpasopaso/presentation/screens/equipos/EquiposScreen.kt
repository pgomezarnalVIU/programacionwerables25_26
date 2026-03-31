package com.example.clubbasquetpasopaso.presentation.screens.equipos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clubbasquetpasopaso.R
import com.example.clubbasquetpasopaso.domain.model.Equipo
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.presentation.components.AppScaffold
import com.example.clubbasquetpasopaso.presentation.navigation.Routes

@Composable
fun EquiposScreen(listEquiposViewModel: ListEquiposViewModel,
                  onNavegarHome:()->Unit,onBack:()->Unit){
    AppScaffold(
        title = "Equipos",
        idLeft =  R.drawable.arrow_back,
        idRight = R.drawable.home_logo,
        onLeftClick = {onBack()},
        onRightClick = {onNavegarHome()}
    ) { modifier ->
        Column(
            modifier = modifier.padding(16.dp)
        )
        {
            LazyColumn {
                items(listEquiposViewModel.equipos.value){
                    equipo->
                    EquipoItem(equipo)
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}

@Composable
fun EquipoItem(equipo: Equipo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = equipo.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            EquipoTypeBadge(equipo.tipo)
        }
    }
}

@Composable
fun EquipoTypeBadge(type: Tipo) {

    val color = when(type){
        Tipo.FEMENINO -> Color(0xFFE91E63)
        Tipo.MASCULINO -> Color(0xFF2196F3)
        Tipo.MIXTO -> Color(0xFF4CAF50)
    }

    val text = when(type){
        Tipo.FEMENINO -> "Femenino"
        Tipo.MASCULINO -> "Masculino"
        Tipo.MIXTO -> "Mixto"
    }
    Box(
        modifier = Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ){
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}