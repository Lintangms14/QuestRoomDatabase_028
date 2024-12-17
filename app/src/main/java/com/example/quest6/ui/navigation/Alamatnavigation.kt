package com.example.quest6.ui.navigation

interface alamatnavigation {
    val route: String

    object DestinasiHome : alamatnavigation {
        override val route = "home"
    }
    object DestinasiDetail : alamatnavigation {
        override val route = "detail"
        const val NIM = "nim"
        val routeWithArgs = "$route/{$NIM}"
    }

    object DestinasiUpdate : alamatnavigation {
        override val route = "update"
        const val NIM = "nim"
        val routeWithArgs = "$route/{$NIM}"
    }

    object DestinasiEdit : alamatnavigation {
        override val route = "edit"
        const val NIM = "nim"
        val routeWithArgs = "$route/{$NIM}"
    }
}