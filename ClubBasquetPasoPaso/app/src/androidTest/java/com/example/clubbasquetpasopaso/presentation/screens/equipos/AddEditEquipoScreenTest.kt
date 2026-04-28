package com.example.clubbasquetpasopaso.presentation.screens.equipos

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.clubbasquetpasopaso.domain.data.local.dao.EquipoDao
import com.example.clubbasquetpasopaso.domain.data.local.database.AppDatabase
import com.example.clubbasquetpasopaso.domain.data.local.repository.EquipoRepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddEditEquipoScreenTest {
    private lateinit var db: AppDatabase
    private lateinit var dao: EquipoDao

    private lateinit var addEditViewModel:AddEditEquipoViewModel

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = AppDatabase.getInstance(context.applicationContext)
        dao = db.equipoDao()

        addEditViewModel = AddEditEquipoViewModel (
            null,
            EquipoRepositoryImpl(db.equipoDao())
        )
    }

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun verify_min_nombre_equipo_not_active_button(){
        //given
        rule.setContent {
            AddEditEquipoScreen(addEditViewModel,
                {},{})
        }
        //when
        rule.onNodeWithTag(INPUT_EQUIPO)
            .performTextInput("Pr")
        //then
        rule.onNodeWithTag(BUTTON_INSERT).assertIsNotEnabled()

    }

    @Test
    fun verify_nombre_equipo_active_button(){
        //given
        rule.setContent {
            AddEditEquipoScreen(addEditViewModel,
                {},{})
        }
        //when
        rule.onNodeWithTag(INPUT_EQUIPO)
            .performTextInput("Cadete A")
        //then
        rule.onNodeWithTag(BUTTON_INSERT).assertIsEnabled()

    }

    @Test
    fun verify_insert_equipo()= runTest {
        //given
        rule.setContent {
            AddEditEquipoScreen(addEditViewModel,
                {},{})
        }

        //when
        rule.onNodeWithTag(INPUT_EQUIPO)
            .performTextInput("Cadete A")

        rule.onNodeWithTag(TEXT_CAT)
            .performClick()
        rule.onNodeWithText("CADETE")
            .performClick()

        rule.onNodeWithTag(TEXT_TIP)
            .performClick()
        rule.onNodeWithText("MASCULINO")
            .performClick()

        rule.onNodeWithTag(BUTTON_INSERT)
            .performClick()

        rule.waitForIdle()

        val equipos = dao.getAllEquipos().first()

        //then
        assertEquals("Cadete A", equipos[0].nombre)
        assertEquals(3, equipos[0].categoria)
        assertEquals(1, equipos[0].tipo)

    }

    @After
    fun tearDown() {
        db.close()
    }

}