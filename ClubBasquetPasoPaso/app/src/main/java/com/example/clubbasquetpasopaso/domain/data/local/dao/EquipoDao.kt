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

    @Query(value="SELECT * FROM equipos ORDER BY id DESC")
    fun getAllEquipos(): Flow<List<EquipoEntity>>

    @Query(value="SELECT * FROM equipos ORDER BY nombre ASC")
    fun getAllEquiposOrderByNombre(): Flow<List<EquipoEntity>>

    @Query(value="SELECT * FROM equipos WHERE id= :id")
    suspend fun getEquipoById(id:Int): EquipoEntity

    @Insert
    suspend fun insertEquipo(equipo: EquipoEntity)

    @Update
    suspend fun updateEquipo(equipo: EquipoEntity)

    @Delete
    suspend fun deleteEquipo(equipo: EquipoEntity)
}