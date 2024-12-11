package com.example.quest6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.quest6.data.entity.mahasiswa

@Dao
interface mahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: mahasiswa)
}