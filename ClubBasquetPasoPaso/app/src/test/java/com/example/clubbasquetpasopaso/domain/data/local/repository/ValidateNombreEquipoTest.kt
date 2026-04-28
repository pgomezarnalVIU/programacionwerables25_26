package com.example.clubbasquetpasopaso.domain.data.local.repository

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ValidateNombreEquipoTest {
    private val validateNombreEquipo = ValidateNombreEquipo()

    @Test
    fun verify_empty_string_is_invalid(){
        val status = validateNombreEquipo("")
        assertFalse(status)
    }

    @Test
    fun verify_length_under_three_is_invalid(){
        val status = validateNombreEquipo("Pr")
        assertFalse(status)
    }

    @Test
    fun verify_length_over_three_is_valid(){
        val status = validateNombreEquipo("Junior A")
        assertTrue(status)
    }
}