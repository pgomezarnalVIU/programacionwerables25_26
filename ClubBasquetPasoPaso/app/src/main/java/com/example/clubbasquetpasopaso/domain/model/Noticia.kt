package com.example.clubbasquetpasopaso.domain.model

enum class TipoNoticia(val tipo: Long) {
    EVENTO(0),
    COMPETICION(1),
    CLUB(2);

    companion object {
        fun fromInt(tipo: Long): TipoNoticia {
            return entries.find { it.tipo == tipo } ?: CLUB
        }
    }
}
data class Noticia(
    val id: String= "",
    val titulo: String = "",
    val tipo: TipoNoticia = TipoNoticia.CLUB,
    val descripcion: String = ""
)