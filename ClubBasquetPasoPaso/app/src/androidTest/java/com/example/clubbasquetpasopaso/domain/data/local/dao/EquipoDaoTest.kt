package com.example.clubbasquetpasopaso.domain.data.local.dao

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.clubbasquetpasopaso.domain.data.local.database.AppDatabase
import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity
import com.example.clubbasquetpasopaso.domain.model.Equipo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EquipoDaoTest {
    private  lateinit var db: AppDatabase
    private  lateinit var dao: EquipoDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = AppDatabase.getInstance(context.applicationContext)
        dao = db.equipoDao()
    }

    @Test
    fun verify_sort_insert_teams() = runTest{
        //given
        val primer_equipo = EquipoEntity(nombre="Primer equipo",categoria=0,tipo=0)
        val segundo_equipo = EquipoEntity(nombre="Equipo segundo",categoria=0,tipo=0)

        //when
        dao.insertEquipo(primer_equipo)
        dao.insertEquipo(segundo_equipo)

        val equipos = dao.getAllEquiposOrderByNombre().first()

        //then
        assertEquals("Equipo segundo",equipos[0].nombre)
    }

    @After
    fun tearDown() {
        db.close()
    }

}