package com.example.clubbasket.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clubbasket.R
import com.example.clubbasket.ui.theme.AccentOrange
import com.example.clubbasket.ui.theme.ContentBackground
import com.example.clubbasket.ui.theme.OverlayBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    idLeft:Int = R.drawable.home_logo,
    idRight:Int = R.drawable.person,
    onLeftClick: (() -> Unit)? = null,
    onRightClick: (() -> Unit)? = null,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        containerColor = ContentBackground,
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(),
                    title = { Text(text = title) },
                    navigationIcon = {
                        if (onLeftClick != null){
                                IconButton(onClick = onLeftClick) {
                                    Icon(
                                        painter = painterResource(idLeft),
                                        modifier = Modifier.size(24.dp),
                                        contentDescription = "Volver",
                                    )
                                }
                        }
                    },
                    actions = {
                        if (onRightClick != null) {
                            IconButton(onClick = onRightClick) {
                                Icon(
                                    painter = painterResource(idRight),
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = "Volver",
                                )
                            }
                        }
                    },
                )

                HorizontalDivider(
                    thickness = 2.dp,
                    color = AccentOrange
                )
            }
        }
    ) { innerPadding ->
        content(
            Modifier
                .fillMaxSize()
                .background(OverlayBlack)
                .padding(innerPadding)
        )
    }
}