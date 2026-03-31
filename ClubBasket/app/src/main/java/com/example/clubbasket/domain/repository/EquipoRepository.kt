package com.example.clubbasket.domain.repository

import com.example.clubbasket.domain.model.Equipo
import kotlinx.coroutines.flow.Flow

interface EquipoRepository {
    fun getAllEquipos(): Flow<List<Equipo>>
    suspend fun insertEquipo(equipo: Equipo)
    suspend fun insertEquipos(equipos: List<Equipo>)
}