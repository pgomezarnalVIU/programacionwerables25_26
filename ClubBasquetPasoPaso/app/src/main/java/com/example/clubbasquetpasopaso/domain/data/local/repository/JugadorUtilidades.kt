package com.example.clubbasquetpasopaso.domain.data.local.repository

import com.example.clubbasquetpasopaso.domain.model.Jugador
import com.example.clubbasquetpasopaso.domain.model.Noticia

data class EstadisticasJugador(
    val porcentaje_tres: Float,
    val porcentaje_dos: Float,
    val porcentaje_uno: Float,
)

sealed interface EstadisticasState {
    data class Success(val estadisticasJugador: EstadisticasJugador) : EstadisticasState
    data class Error(val message: String) : EstadisticasState
}

class JugadorUtilidades {

    // Funcion que calcula las estadísticas de un jugador a partir de una
    // de un jugador. Si el jugador es vacio devuelve un error
    fun resumenEstadisticas(jugador: Jugador):EstadisticasState{
        if(jugador.id==null)
            return EstadisticasState.Error("Jugador vacio")
        else{
            return EstadisticasState.Success(
                EstadisticasJugador(
                    porcentaje_tres =
                        (jugador.tiros_tres_tirados.toFloat()/jugador.tiros_tres_anotados),
                    porcentaje_dos =
                        (jugador.tiros_dos_tirados.toFloat()/jugador.tiros_dos_anotados),
                    porcentaje_uno =
                        (jugador.tiros_uno_tirados.toFloat()/jugador.tiros_uno_anotados),
                )
            )
        }
    }
}