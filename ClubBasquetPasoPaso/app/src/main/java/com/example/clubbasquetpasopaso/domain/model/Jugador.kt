package com.example.clubbasquetpasopaso.domain.model

import com.example.clubbasquetpasopaso.domain.model.Categoria.SENIOR

enum class Posicion(val posicion: Int) {
    PIVOT(0),
    ALERO(1),
    ESCOLTA(2),
    BASE(3);

    companion object {
        fun fromInt(posicion: Int) : Posicion{
            return entries.find {it.posicion == posicion} ?: BASE
        }
    }
}

data class Jugador(
    val id: Int? = null,
    val nombre: String = "",
    val categoria: Categoria = Categoria.INFANTIL,
    val posicion: Posicion = Posicion.BASE,
    val tiros_tres_anotados: Int = 0,
    val tiros_tres_tirados: Int = 0,
    val tiros_dos_anotados: Int = 0,
    val tiros_dos_tirados: Int = 0,
    val tiros_uno_anotados: Int = 0,
    val tiros_uno_tirados: Int = 0
)