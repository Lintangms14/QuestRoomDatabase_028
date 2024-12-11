package com.example.quest6.repository

import com.example.quest6.data.entity.mahasiswa

interface repositoryMhs {
    suspend fun insertMhs(mahasiswa: mahasiswa)
}