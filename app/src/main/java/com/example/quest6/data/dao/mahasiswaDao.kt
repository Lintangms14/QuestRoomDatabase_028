package com.example.quest6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.quest6.data.entity.mahasiswa

@Dao
interface mahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: mahasiswa)

    @Update
    suspend fun updateMahasiswa(mahasiswa: mahasiswa)
}