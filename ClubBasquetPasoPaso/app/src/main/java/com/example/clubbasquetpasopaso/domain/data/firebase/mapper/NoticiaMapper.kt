package com.example.clubbasquetpasopaso.domain.data.firebase.mapper

import com.example.clubbasquetpasopaso.domain.data.firebase.dto.NoticiaDto
import com.example.clubbasquetpasopaso.domain.model.Noticia
import com.example.clubbasquetpasopaso.domain.model.TipoNoticia

fun NoticiaDto.toDomain(): Noticia = Noticia(
    id = id,
    titulo = titulo,
    tipo = TipoNoticia.fromInt(tipo?: 2),
    descripcion = descripcion

)

fun Noticia.toDto(): NoticiaDto = NoticiaDto(
    id = id,
    titulo = titulo,
    tipo = tipo.tipo,
    descripcion = descripcion
)