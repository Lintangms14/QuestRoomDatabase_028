package com.example.quest6.dependenciesinjection

import android.content.Context
import com.example.quest6.data.database.KrsDatabase
import com.example.quest6.repository.localrepositoryMhs
import com.example.quest6.repository.repositoryMhs

interface InterfacecontainerApp{
    val repositoryMhs : repositoryMhs
}

class ContainerApp (private val context: Context): InterfacecontainerApp{
    override val repositoryMhs: repositoryMhs by lazy {
        localrepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}