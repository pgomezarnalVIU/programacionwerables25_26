package com.example.clubbasquetpasopaso.presentation.screens.equipos


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clubbasquetpasopaso.domain.data.local.repository.ValidateNombreEquipo
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Equipo
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.domain.repository.EquipoRepository
import kotlinx.coroutines.launch


class AddEditEquipoViewModel(val id:Int?=null,val equipoRepository: EquipoRepository): ViewModel() {

    private val _equipo = mutableStateOf(Equipo())
    var equipo : State<Equipo> = _equipo

    init{
        loadEquipo()
    }
    fun loadEquipo(){
        if(id!=null)
            viewModelScope.launch {
                _equipo.value = equipoRepository.getEquipoById(id)
                equipo = _equipo
            }
    }

    // Funciones de actualizacion de los datos del equipo
    fun addNombre(nombre:String){
        _equipo.value = _equipo.value.copy(nombre=nombre)
    }
    fun validarNombreEquipo(): Boolean {
        val validateNombreEquipo = ValidateNombreEquipo()
        return validateNombreEquipo(_equipo.value.nombre)
    }
    fun addCategoria(categoria: Categoria){
        _equipo.value = _equipo.value.copy(categoria=categoria)
    }
    fun addTipo(tipo: Tipo){
        _equipo.value = _equipo.value.copy(tipo=tipo)
    }

    //Funcion de insert o actualizacion del equipo
    fun addEditEquipo(){
        if(id==null)
            viewModelScope.launch {
                equipoRepository.insertEquipo(_equipo.value)
            }
        else
            viewModelScope.launch {
                equipoRepository.updateEquipo(_equipo.value)
            }
    }
}