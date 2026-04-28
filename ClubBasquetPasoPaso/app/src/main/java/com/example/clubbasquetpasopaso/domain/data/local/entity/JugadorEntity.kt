package com.example.clubbasquetpasopaso.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Posicion

@Entity(tableName = "Jugadores")
data class JugadorEntity (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nombre: String,
    val categoria: Int,
    val posicion: Int,
    val tiros_tres_anotados: Int,
    val tiros_tres_tirados: Int,
    val tiros_dos_anotados: Int,
    val tiros_dos_tirados: Int,
    val tiros_uno_anotados: Int,
    val tiros_uno_tirados: Int
)
