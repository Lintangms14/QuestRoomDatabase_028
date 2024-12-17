package com.example.quest6.repository

import com.example.quest6.data.dao.mahasiswaDao
import com.example.quest6.data.entity.mahasiswa
import kotlinx.coroutines.flow.Flow

class localrepositoryMhs(
    private val mahasiswaDao: mahasiswaDao
): repositoryMhs {
    override suspend fun insertMhs(mahasiswa: mahasiswa){
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }

    override fun getAllMhs(): Flow<List<mahasiswa>> {
        return mahasiswaDao.getAllMahasiswa()
    }

    override fun getMhs(nim: String): Flow<mahasiswa> {
        return mahasiswaDao.getMahasiswa(nim)
    }

    override suspend fun deleteMhs(mahasiswa: mahasiswa) {
        mahasiswaDao.deleteMahasiswa(mahasiswa)
    }

    override suspend fun updateMhs(mahasiswa: mahasiswa) {
        mahasiswaDao.updateMahasiswa(mahasiswa)
    }
}