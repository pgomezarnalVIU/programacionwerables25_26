package com.example.clubbasquetpasopaso.domain.repository

import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity
import com.example.clubbasquetpasopaso.domain.model.Equipo
import kotlinx.coroutines.flow.Flow

interface EquipoRepository {

    fun getAllEquipos(): Flow<List<Equipo>>
    suspend fun getEquipoById(id:Int): Equipo

    suspend fun insertEquipo(equipo: Equipo)
    suspend fun insertDefaultsEquipos()

    suspend fun updateEquipo(equipo: Equipo)

    suspend fun deleteEquipo(equipo: Equipo)
}