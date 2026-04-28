package com.example.clubbasquetpasopaso.domain.data.local.repository

import com.example.clubbasquetpasopaso.domain.model.Jugador
import org.junit.Assert.assertEquals
import org.junit.Test

class JugadorUtilidadesTest {
    private val jugadorUtilidades = JugadorUtilidades()

    @Test
    fun verify_empty_jugador_returns_error() {
        //given
            val jugador = Jugador()
        //when
            val estadisticasJugador = jugadorUtilidades.resumenEstadisticas(jugador)
        //then
            assertEquals(EstadisticasState.Error("Jugador vacio"),estadisticasJugador)
    }

}