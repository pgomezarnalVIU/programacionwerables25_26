package com.example.clubbasquetpasopaso.domain.model

import com.example.clubbasquetpasopaso.domain.model.Categoria.SENIOR

enum class Categoria(val categoria: Int) {
    BENJAMIN(0),
    ALEVÍN(1),
    INFANTIL(2),
    CADETE(3),
    JUNIOR(4),
    SENIOR(5);

    companion object {
        fun fromInt(categoria: Int) : Categoria{
            return entries.find {it.categoria == categoria} ?: SENIOR
        }
    }
}
enum class Tipo(val tipo: Int) {
    FEMENINO(0),
    MASCULINO(1),
    MIXTO(2);

    companion object {
        fun fromInt(tipo: Int): Tipo {
            return Tipo.entries.find { it.tipo == tipo } ?: MIXTO
        }
    }
}
data class Equipo(
    val id: Int? = null,
    val nombre: String = "",
    val categoria: Categoria = Categoria.INFANTIL,
    val tipo: Tipo = Tipo.MIXTO
)