package com.example.clubbasquetpasopaso.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey {
    @Serializable
    data object Login : Routes()
    @Serializable
    data object Home : Routes()
    @Serializable
    data object Perfil:Routes()
    @Serializable
    data object Equipos:Routes()
    @Serializable
    data class AddEditEquipo(val id:Int?=null):Routes()
    @Serializable
    data object Noticias:Routes()
}