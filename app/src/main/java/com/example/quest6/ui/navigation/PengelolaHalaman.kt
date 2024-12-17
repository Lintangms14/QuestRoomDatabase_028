package com.example.quest6.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quest6.ui.view.mahasiswa.DestinasiInsert
import com.example.quest6.ui.view.mahasiswa.DetailMhsView
import com.example.quest6.ui.view.mahasiswa.HomeMhsView
import com.example.quest6.ui.view.mahasiswa.InsertMhsView
import com.example.quest6.ui.view.mahasiswa.UpdateMhsView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = alamatnavigation.DestinasiHome.route) {
        composable(
            route = alamatnavigation.DestinasiHome.route
        ) {
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${alamatnavigation.DestinasiDetail.route}/$nim")
                    println(
                        "PengelolaHalaman: nim = $nim"
                    )
                },
                onAddMhs = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }

        composable(
            route = DestinasiInsert.route
        ) {
            InsertMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
            )
        }

        composable(
            alamatnavigation.DestinasiDetail.routeWithArgs,
            arguments = listOf(
                navArgument(alamatnavigation.DestinasiDetail.NIM) {
                    type = NavType.StringType
                }
            )
        ) {
            val nim = it.arguments?.getString(alamatnavigation.DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${alamatnavigation.DestinasiEdit.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(
            alamatnavigation.DestinasiEdit.routeWithArgs,
            arguments = listOf(
                navArgument(alamatnavigation.DestinasiEdit.NIM) {
                    type = NavType.StringType
                }
            )
        ) {
            UpdateMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
            )
        }
    }
}