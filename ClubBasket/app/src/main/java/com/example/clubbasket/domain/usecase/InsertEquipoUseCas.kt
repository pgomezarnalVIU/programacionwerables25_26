package com.example.clubbasket.domain.usecase

import com.example.clubbasket.domain.model.Equipo
import com.example.clubbasket.domain.repository.EquipoRepository

class InsertEquipoUseCas (
    private val repository: EquipoRepository
){
    suspend fun invoke(equipo: Equipo){
        repository.insertEquipo(equipo)
    }
}