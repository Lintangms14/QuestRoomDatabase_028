package com.example.quest6.repository

import com.example.quest6.data.dao.mahasiswaDao
import com.example.quest6.data.entity.mahasiswa

class localrepositoryMhs(
    private val mahasiswaDao: mahasiswaDao
): repositoryMhs {
    override suspend fun insertMhs(mahasiswa: mahasiswa){
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
}