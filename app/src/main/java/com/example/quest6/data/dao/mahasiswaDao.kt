package com.example.quest6.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quest6.data.entity.mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface mahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: mahasiswa)

    @Update
    suspend fun updateMahasiswa(mahasiswa: mahasiswa)

    @Delete
    suspend fun deleteMahasiswa(mahasiswa: mahasiswa)

    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<mahasiswa>>

    //getMahasiswa
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim: String): Flow<mahasiswa>
}