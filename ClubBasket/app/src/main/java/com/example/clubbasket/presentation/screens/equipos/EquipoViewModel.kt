package com.example.clubbasket.presentation.screens.equipos

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clubbasket.domain.usecase.GetAllEquiposUseCase
import com.example.clubbasket.domain.usecase.InsertEquipoUseCas
import com.example.clubbasket.domain.usecase.InsertSampleEquipoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EquipoViewModel(
    private val getAllEquiposUseCase: GetAllEquiposUseCase,
    private val insertEquipoUseCase: InsertEquipoUseCas,
    private val insertSampleEquiposUseCase: InsertSampleEquipoUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<EquipoUiState>(EquipoUiState.Loading)
    val uiState: StateFlow<EquipoUiState> = _uiState.asStateFlow()

    init {
        loadEquipos()
    }

    private fun loadEquipos(){
        viewModelScope.launch {
            getAllEquiposUseCase().catch { exception ->
                _uiState.value = EquipoUiState.Error(message = exception.message ?: "Error desconocido")
            }
                .collect { equipos ->
                    _uiState.value = EquipoUiState.Success(
                        equipos = equipos
                    )
                }
        }
    }

    fun insertSampleEquipos(){
        viewModelScope.launch {
            try{
                val currentState = _uiState.value
                if (currentState is EquipoUiState.Success){
                    _uiState.value = currentState.copy(isLoading = true)
                }
                //Insert data
                insertSampleEquiposUseCase()
            }catch (e: Exception){
                _uiState.value = EquipoUiState.Error(message = e.message ?: "Error desconocido")
            }
        }
    }
}