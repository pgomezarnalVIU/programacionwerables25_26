package com.example.clubbasquetpasopaso.presentation.screens.perfil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clubbasquetpasopaso.R
import com.example.clubbasquetpasopaso.presentation.components.AppScaffold

@Composable
fun PerfilScreen(onNavegarHome:()->Unit,onBack:()->Unit){
    AppScaffold(
        title = "Perfil",
        idLeft =  R.drawable.arrow_back,
        idRight = R.drawable.home_logo,
        onLeftClick = {onBack()},
        onRightClick = {onNavegarHome()}
    ) { modifier ->
        Column(
            modifier = modifier.padding(16.dp)
        )
        {
            Text(
                text = "Perfil",
            )
        }
    }
}