package com.example.clubbasquetpasopaso.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.clubbasquetpasopaso.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    idLeft:Int = R.drawable.home_logo,
    idRight:Int = R.drawable.person,
    onLeftClick: (() -> Unit)? = null,
    onRightClick: (() -> Unit)? = null,
    onFloatClick: (() -> Unit)? = null,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            if (onFloatClick != null) {
                FloatingActionButton(
                    onClick = onFloatClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                  }
            }
        },
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(R.color.topBarBackground),
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    if (onLeftClick != null){
                        IconButton(onClick = onLeftClick) {
                            Icon(
                                painter = painterResource(idLeft),
                                modifier = Modifier.size(28.dp),
                                contentDescription = "Home",
                                tint = Color.White
                            )
                        }
                    }
                },
                actions = {
                    if (onRightClick != null) {
                        IconButton(onClick = onRightClick) {
                            Icon(
                                painter = painterResource(idRight),
                                modifier = Modifier.size(28.dp),
                                tint = Color.White,
                                contentDescription = "Perfil de usuario"
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        content(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}