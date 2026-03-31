package com.example.clubbasquetpasopaso.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Equipos")
data class EquipoEntity (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nombre: String,
    val categoria: Int,
    val tipo: Int
)
