package com.example.clubbasquetpasopaso.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.clubbasquetpasopaso.R
import com.example.clubbasquetpasopaso.presentation.components.AppScaffold
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.clubbasquetpasopaso.presentation.navigation.Routes

data class MenuItemUi(
    val title: String,
    val imageRes: Int,
    val route: Routes
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavegarPerfil:()->Unit, onNavegarScreen: (Routes)->Unit){

    val enlaces = listOf(
        MenuItemUi("Noticias", R.drawable.noticias_logo, Routes.Equipos),
        MenuItemUi("Equipos", R.drawable.equipos_logo, Routes.Equipos),
        MenuItemUi("Mi Equipo", R.drawable.mi_equipo_logo, Routes.Equipos),
        MenuItemUi("Estadísticas", R.drawable.estadisticas_logo, Routes.Equipos)
    )

    AppScaffold(
        title = "Home",
        onRightClick = { onNavegarPerfil() }
    ) { modifier ->
        Box(
            modifier = modifier
                .fillMaxSize()
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                items(enlaces){ item ->
                    BasketballMenuCard(
                        title = item.title,
                        imageRes = item.imageRes,
                        route = item.route,
                        modifier = Modifier.fillMaxWidth(),
                        onNavegarScreen = onNavegarScreen
                    )
                }
            }
        }
    }
}

@Composable
fun BasketballMenuCard(
    title: String,
    imageRes: Int,
    route: Routes,
    modifier: Modifier = Modifier,
    onNavegarScreen: (Routes)->Unit
) {
    Card(
        onClick = { onNavegarScreen(route)},
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.cardBg)),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.88f)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Transparent,
                                    Color(0x22000000),
                                    Color(0xCC000000)
                                )
                            )
                        )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF151515))
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(colorResource(R.color.orangeAccent))
            )
        }
    }
}
