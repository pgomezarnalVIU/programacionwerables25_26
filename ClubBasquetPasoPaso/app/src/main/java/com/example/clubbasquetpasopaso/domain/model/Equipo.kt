package com.example.clubbasquetpasopaso.domain.model

enum class Categoria {
    BENJAMIN,
    ALEVÍN,
    INFANTIL,
    CADETE,
    JUNIOR,
    SENIOR
}
enum class Tipo {
    FEMENINO,
    MASCULINO,
    MIXTO
}
data class Equipo(
    val id: Int=0,
    val nombre: String = "",
    val categoria: Categoria = Categoria.INFANTIL,
    val tipo: Tipo = Tipo.MIXTO
)