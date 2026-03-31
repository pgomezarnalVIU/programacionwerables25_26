package com.example.clubbasquetpasopaso.presentation.screens.equipos

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clubbasquetpasopaso.domain.data.local.dao.EquipoDao
import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Equipo
import com.example.clubbasquetpasopaso.domain.model.Tipo
import kotlinx.coroutines.launch

//Ejemplo de equipos
val sampleEquipos = listOf(
    Equipo(0,nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.MASCULINO),
    Equipo(1,nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.FEMENINO),
    Equipo(2,nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
    Equipo(3,nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
    Equipo(4,nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
    Equipo(5,nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
    Equipo(6,nombre = "Benjamin Preferente A", categoria = Categoria.BENJAMIN, tipo = Tipo.MIXTO)
)

class ListEquiposViewModel(val equipoDao: EquipoDao): ViewModel() {

    //Variable en memoria equipos
    private val _equipos: MutableState<List<Equipo>> = mutableStateOf(emptyList())
    //Variable publica
    var equipos: State<List<Equipo>> = _equipos

    init{
        loadEquipos()
    }
    private fun loadEquipos(){
        //De forma temporal
        _equipos.value = sampleEquipos
        //Anyadir un dato a la DB
        val equipo = EquipoEntity(nombre = "Cadete Preferente A", categoria = 1, tipo = 1)
        viewModelScope.launch {
            equipoDao.insertEquipo(equipo)
        }
    }
}