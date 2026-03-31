package com.example.clubbasket.domain.data.local.repository

import com.example.clubbasket.domain.data.local.dao.EquipoDao
import com.example.clubbasket.domain.data.local.mapper.toDomainModels
import com.example.clubbasket.domain.data.local.mapper.toEntities
import com.example.clubbasket.domain.data.local.mapper.toEntity
import com.example.clubbasket.domain.model.Equipo
import com.example.clubbasket.domain.repository.EquipoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EquipoRepositoryIml(
    private val equipoDao: EquipoDao
): EquipoRepository {
    override fun getAllEquipos(): Flow<List<Equipo>>{
        return equipoDao.getAllEquipos()
            .map { entities ->  entities.toDomainModels() }
    }

    override suspend fun insertEquipo(equipo: Equipo) {
        equipoDao.insertEquipo(equipo.toEntity())
    }

    override suspend fun insertEquipos(equipos: List<Equipo>) {
        equipoDao.insertAllEquipos(equipos.toEntities())
    }
}