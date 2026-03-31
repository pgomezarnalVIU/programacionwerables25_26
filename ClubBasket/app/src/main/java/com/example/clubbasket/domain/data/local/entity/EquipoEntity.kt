package com.example.clubbasket.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.clubbasket.domain.model.Categoria
import com.example.clubbasket.domain.model.Tipo

@Entity(tableName = "Equipos")
data class EquipoEntity (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nombre: String,
    val categoria: Categoria,
    val tipo: Tipo
) {
}