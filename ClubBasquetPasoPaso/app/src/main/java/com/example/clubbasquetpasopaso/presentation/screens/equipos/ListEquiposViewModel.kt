package com.example.clubbasquetpasopaso.presentation.screens.equipos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Equipo
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.domain.repository.EquipoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


//Ejemplo de equipos
val sampleEquipos = listOf(
    Equipo(0, nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.MASCULINO),
    Equipo(1, nombre = "Cadete Preferente A", categoria = Categoria.CADETE, tipo = Tipo.FEMENINO),
    Equipo(2, nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
    Equipo(3, nombre = "Infantil Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
    Equipo(4, nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.MASCULINO),
    Equipo(5, nombre = "Alevin Preferente A", categoria = Categoria.ALEVÍN, tipo = Tipo.FEMENINO),
    Equipo(6, nombre = "Benjamin Preferente A", categoria = Categoria.BENJAMIN, tipo = Tipo.MIXTO)
)

class ListEquiposViewModel(val equipoRepository: EquipoRepository): ViewModel() {

    //Variable en memoria equipos
    //private val _equipos: MutableState<List<Equipo>> = mutableStateOf(emptyList())
    //Variable publica
    val equipos: StateFlow<List<Equipo>> = equipoRepository.getAllEquipos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init{
        //loadEquipos()
    }
    private fun loadEquipos(){
        //De forma temporal
        //_equipos.value = sampleEquipos
        //Anyadir un dato a la DB
        //val equipo = Equipo(id=null,nombre = "Cadete Preferente A Femenino", categoria = Categoria.CADETE, tipo = Tipo.FEMENINO)
        //viewModelScope.launch {
        //    equipoRepository.insertEquipo(equipo)
        //}
    }

}