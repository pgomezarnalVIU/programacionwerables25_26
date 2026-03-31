package com.example.clubbasquetpasopaso.domain.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clubbasquetpasopaso.domain.data.local.dao.EquipoDao
import com.example.clubbasquetpasopaso.domain.data.local.entity.EquipoEntity

@Database(
    entities = [EquipoEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun equipoDao(): EquipoDao

    // Creacion de la instancia estatica para generar una
    // nueva BBDD

    companion object{
        @Volatile
        private var instance: AppDatabase ?= null

        fun getInstance(context: Context): AppDatabase{
            return instance ?: synchronized(this){
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "clubbasket.db",
                )
                    .fallbackToDestructiveMigration(dropAllTables = true)
                    .build()
                    .also { instance = it }
            }
        }
    }
}