package com.example.clubbasquetpasopaso.domain.data.local.repository

import com.example.clubbasquetpasopaso.domain.data.local.dao.EquipoDao
import com.example.clubbasquetpasopaso.domain.data.local.mapper.toDomain
import com.example.clubbasquetpasopaso.domain.data.local.mapper.toEntity
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Equipo
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.domain.repository.EquipoRepository
import com.example.clubbasquetpasopaso.presentation.screens.equipos.sampleEquipos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//Ejemplo de equipos
val sampleEquipos = listOf(
    Equipo(0, nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.MASCULINO),
    Equipo(1, nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.FEMENINO),
    Equipo(2, nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
    Equipo(3, nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
    Equipo(4, nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
    Equipo(5, nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
    Equipo(6, nombre = "Benjamin Preferente A", categoria = Categoria.BENJAMIN, tipo = Tipo.MIXTO)
)
class EquipoRepositoryImpl(private val equipoDao: EquipoDao)  : EquipoRepository {
    override fun getAllEquipos(): Flow<List<Equipo>> {
        return equipoDao.getAllEquipos().map() {
                list  -> list.map { it.toDomain() }
        }
    }
    override suspend fun getEquipoById(id:Int): Equipo {
        return equipoDao.getEquipoById(id).toDomain()
    }

    override suspend fun insertEquipo(equipo: Equipo) {
       return  equipoDao.insertEquipo(equipo.toEntity())
    }

    override suspend fun insertDefaultsEquipos() {
        sampleEquipos.forEach { equipo ->  insertEquipo(equipo)}
    }

    override suspend fun updateEquipo(equipo: Equipo) {
        return  equipoDao.updateEquipo(equipo.toEntity())
    }

    override suspend fun deleteEquipo(equipo: Equipo) {
        return  equipoDao.deleteEquipo(equipo.toEntity())
    }
}