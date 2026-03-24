package com.example.clubbasket.presentation.screens.miequipo

import android.adservices.topics.Topic
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clubbasket.R
import com.example.clubbasket.presentation.components.AppScaffold
import com.example.clubbasket.ui.theme.TextPrimary
import com.example.clubbasket.ui.theme.TopBarBackground

@Composable
fun MiEquipoScreen(onNavegarHome:()->Unit,onBack:()->Unit){
    AppScaffold(
        title = "Mi equipo",
        idLeft = R.drawable.arrow_back,
        R.drawable.home_logo,
        onLeftClick = { onBack()},
        onRightClick = { onNavegarHome()}
    ) { modifier ->
        Column(
            modifier = modifier.padding(16.dp)
        )
        {
            Text(
                text = "Mi equipo",
                color = TextPrimary
            )
        }
    }
}
