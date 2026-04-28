package com.example.clubbasquetpasopaso.domain.data.local.repository

class ValidateNombreEquipo {

    //Funcion que comprueba que el nombre del equipo tenga
    //como mínimo 3 caracteres
    operator fun invoke(name: String): Boolean {
        return name.trim().length >= 3
    }
}