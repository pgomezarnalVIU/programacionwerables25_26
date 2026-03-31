package com.example.clubbasket.domain.usecase

import com.example.clubbasket.domain.repository.EquipoRepository
import kotlinx.coroutines.flow.Flow
import com.example.clubbasket.domain.model.Equipo

class GetAllEquiposUseCase (
    private val repository: EquipoRepository
) {
    // es una función especial que permite que un objeto se
    // comporte como si fuera una función.
    // Es decir, puedes llamar a una instancia
    // GetAllEquiposUseCase(), llamará directamente a invoke
    operator fun invoke(): Flow<List<Equipo>>{
        return repository.getAllEquipos()
    }
}