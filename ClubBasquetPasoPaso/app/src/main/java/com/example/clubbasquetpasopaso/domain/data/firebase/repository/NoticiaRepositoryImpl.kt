package com.example.clubbasquetpasopaso.domain.data.firebase.repository


import com.example.clubbasquetpasopaso.domain.data.firebase.dto.NoticiaDto
import com.example.clubbasquetpasopaso.domain.data.firebase.mapper.toDomain
import com.example.clubbasquetpasopaso.domain.model.Noticia
import com.example.clubbasquetpasopaso.domain.repository.NoticiaRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class NoticiaRepositoryImpl(private val firestore: FirebaseFirestore)  : NoticiaRepository {

    override suspend fun getAllNoticias(): List<Noticia> {
        val snapshot = firestore.collection("noticias")
            .get()
            .await()
        val noticiasDto = snapshot.documents.map { doc ->
            NoticiaDto(
                id = doc.id,
                titulo = doc.getString("titulo").orEmpty(),
                tipo = doc.getLong("tipo"),
                descripcion = doc.getString("descripcion").orEmpty()
            )
        }
        return noticiasDto.map { it.toDomain() }
    }
}