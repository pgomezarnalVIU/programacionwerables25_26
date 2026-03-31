package com.example.clubbasket.domain.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clubbasket.domain.data.local.dao.EquipoDao
import com.example.clubbasket.domain.data.local.entity.EquipoEntity

@Database(entities = [EquipoEntity::class], version = 1)
abstract class EquipoDatabase: RoomDatabase() {
    abstract fun equipoDao(): EquipoDao

    companion object{
        @Volatile
        private var INSTANCE: EquipoDatabase? = null

        fun getDatabase(context: Context) : EquipoDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                                context.applicationContext,
                                EquipoDatabase::class.java,
                                "equipo_database"
                            ).fallbackToDestructiveMigration(false).build()
                INSTANCE = instance
                instance
            }
        }
    }
}