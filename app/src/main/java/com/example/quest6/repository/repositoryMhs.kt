package com.example.quest6.repository

import com.example.quest6.data.entity.mahasiswa
import kotlinx.coroutines.flow.Flow

interface repositoryMhs {
    suspend fun insertMhs(mahasiswa: mahasiswa)

    fun getAllMhs(): Flow<List<mahasiswa>>

    fun getMhs(nim: String): Flow<mahasiswa>

    suspend fun deleteMhs(mahasiswa: mahasiswa)

    suspend fun updateMhs(mahasiswa: mahasiswa)
}