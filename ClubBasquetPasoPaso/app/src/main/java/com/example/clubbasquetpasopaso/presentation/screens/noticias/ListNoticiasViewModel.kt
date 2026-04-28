package com.example.clubbasquetpasopaso.presentation.screens.noticias

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clubbasquetpasopaso.domain.data.firebase.repository.NoticiaRepositoryImpl
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Equipo
import com.example.clubbasquetpasopaso.domain.model.Noticia
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.domain.repository.EquipoRepository
import com.example.clubbasquetpasopaso.domain.repository.NoticiaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed interface NoticiasUiState {
    object Loading : NoticiasUiState
    data class Success(val noticias: List<Noticia>) : NoticiasUiState
    data class Error(val message: String) : NoticiasUiState
}


class ListNoticiasViewModel(val noticiaRepository: NoticiaRepositoryImpl): ViewModel() {

    private val _uiState = MutableStateFlow<NoticiasUiState>(NoticiasUiState.Loading)
    val uiState: StateFlow<NoticiasUiState> = _uiState.asStateFlow()

    init{
        cargarNoticias()
    }

    fun cargarNoticias() {
        viewModelScope.launch {
            try {
                val noticias = noticiaRepository.getAllNoticias()
                _uiState.value = NoticiasUiState.Success(noticias)
            } catch (e: Exception) {
                _uiState.value = NoticiasUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}