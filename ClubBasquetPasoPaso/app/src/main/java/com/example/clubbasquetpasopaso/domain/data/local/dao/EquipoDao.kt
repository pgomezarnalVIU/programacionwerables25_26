package com.example.clubbasquetpasopaso.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipoDao {

    @Query(value="SELECT * FROM equipos")
    fun getAllEquipos(): Flow<List<EquipoEntity>>

    @Insert
    suspend fun insertEquipo(equipo: EquipoEntity)

    @Update
    suspend fun updateEquipo(equipo: EquipoEntity)

    @Delete
    suspend fun deleteEquipo(equipo: EquipoEntity)
}