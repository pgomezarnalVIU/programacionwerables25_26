package com.example.clubbasquetpasopaso.presentation.screens.noticias


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.clubbasquetpasopaso.R
import com.example.clubbasquetpasopaso.domain.model.Noticia
import com.example.clubbasquetpasopaso.presentation.components.AppScaffold


@Composable
fun NoticiasScreen(listNoticiasViewModel: ListNoticiasViewModel,
                  onNavegarHome:()->Unit,
                  onBack:()->Unit) {

    val uiState = listNoticiasViewModel.uiState.collectAsStateWithLifecycle()

    AppScaffold(
        title = "Equipos",
        idLeft = R.drawable.arrow_back,
        idRight = R.drawable.home_logo,
        onLeftClick = { onBack() },
        onRightClick = { onNavegarHome() }
    ) { modifier ->
        when (val state = uiState.value) {
            is NoticiasUiState.Loading -> {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is NoticiasUiState.Success -> {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.noticias) { noticia ->
                        NoticiaItem(noticia = noticia)
                    }
                }
            }

            is NoticiasUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(text = state.message)
                }
            }
        }
    }
}
@Composable
fun NoticiaItem(noticia: Noticia) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = noticia.titulo,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = noticia.tipo.name,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = noticia.descripcion,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}