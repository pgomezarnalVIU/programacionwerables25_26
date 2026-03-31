package com.example.clubbasket.domain.data.local.mapper

import com.example.clubbasket.domain.data.local.entity.EquipoEntity
import com.example.clubbasket.domain.model.Equipo

fun EquipoEntity.toDomainModel(): Equipo {
    return Equipo(
        id= this.id,
        nombre = this.nombre,
        categoria = this.categoria,
        tipo = this.tipo
    )
}

fun Equipo.toEntity(): EquipoEntity {
    return EquipoEntity(
        id= this.id,
        nombre = this.nombre,
        categoria = this.categoria,
        tipo = this.tipo
    )
}

fun List<EquipoEntity>.toDomainModels(): List<Equipo>{
    return this.map { it.toDomainModel() }
}

fun List<Equipo>.toEntities(): List<EquipoEntity>{
    return this.map { it.toEntity() }
}