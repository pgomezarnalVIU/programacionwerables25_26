package com.example.clubbasket.domain.usecase

import com.example.clubbasket.domain.model.Categoria
import com.example.clubbasket.domain.model.Equipo
import com.example.clubbasket.domain.model.Tipo
import com.example.clubbasket.domain.repository.EquipoRepository

class InsertSampleEquipoUseCase(
    private val repository: EquipoRepository
) {
    suspend operator fun invoke(){
        val sampleEquipos = listOf(
            Equipo(nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.MASCULINO),
            Equipo(nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.FEMENINO),
            Equipo(nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
            Equipo(nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
            Equipo(nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
            Equipo(nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
            Equipo(nombre = "Benjamin Preferente A", categoria = Categoria.BENJAMIN, tipo = Tipo.MIXTO)
        )
        repository.insertEquipos(sampleEquipos)
    }
}