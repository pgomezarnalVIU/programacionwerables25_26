package com.example.clubbasquetpasopaso.domain.data.local.mapper

import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.domain.model.Equipo

fun EquipoEntity.toDomain(): Equipo = Equipo(
    id = id,
    nombre = nombre,
    categoria = Categoria.fromInt(categoria),
    /*
    categoria = when(categoria){
        0 -> Categoria.BENJAMIN
        else -> {
            Categoria.SENIOR
        }
    },*/
    tipo = Tipo.fromInt(tipo)
)

fun Equipo.toEntity(): EquipoEntity = EquipoEntity(
    id = id,
    nombre = nombre,
    categoria = categoria.categoria,
    tipo = tipo.tipo
)