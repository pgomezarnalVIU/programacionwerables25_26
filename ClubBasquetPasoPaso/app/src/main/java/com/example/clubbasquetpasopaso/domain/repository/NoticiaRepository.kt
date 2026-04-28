package com.example.clubbasquetpasopaso.domain.repository


import com.example.clubbasquetpasopaso.domain.model.Noticia
import kotlinx.coroutines.flow.Flow

interface NoticiaRepository {

    suspend fun getAllNoticias(): List<Noticia>
}