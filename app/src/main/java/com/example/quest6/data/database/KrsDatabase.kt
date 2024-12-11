package com.example.quest6.data.database

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quest6.data.dao.mahasiswaDao
import com.example.quest6.data.entity.mahasiswa

@Database(entities = [mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase(){
    abstract fun mahasiswaDao(): mahasiswaDao

    companion object {
        @Volatile
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java,
                    "krsDatabase"
                )
                    .build().also { Instance = it }
            })
        }
    }
}