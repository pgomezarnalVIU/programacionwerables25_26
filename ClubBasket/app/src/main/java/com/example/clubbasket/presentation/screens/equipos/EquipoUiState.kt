package com.example.clubbasket.presentation.screens.equipos

import com.example.clubbasket.domain.model.Equipo

sealed interface EquipoUiState {
    data object Loading: EquipoUiState

    data class Success(
        val equipos: List<Equipo>,
        val isLoading: Boolean = false
        ): EquipoUiState

    data class Error (val message: String): EquipoUiState
}