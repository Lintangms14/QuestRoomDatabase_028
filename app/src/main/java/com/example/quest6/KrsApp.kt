package com.example.quest6

import android.app.Application
import com.example.quest6.dependenciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate(){
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}