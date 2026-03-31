package com.example.clubbasquetpasopaso.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.clubbasquetpasopaso.domain.data.local.database.AppDatabase
import com.example.clubbasquetpasopaso.presentation.screens.equipos.EquiposScreen
import com.example.clubbasquetpasopaso.presentation.screens.equipos.ListEquiposViewModel
import com.example.clubbasquetpasopaso.presentation.screens.home.HomeScreen
import com.example.clubbasquetpasopaso.presentation.screens.perfil.PerfilScreen

@Composable
fun NavigationWrapper(db: AppDatabase){

    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider
        {
            entry<Routes.Home>{
                HomeScreen(
                    onNavegarPerfil ={backStack.add(Routes.Perfil)},
                    onNavegarScreen = {route->backStack.add(route)}
                )
            }
            entry<Routes.Perfil>{
                PerfilScreen(
                    onNavegarHome = {backStack.add(Routes.Home)},
                    onBack = {backStack.removeLastOrNull()}
                )
            }
            entry<Routes.Equipos>{
                val listEquiposViewModel = viewModel<ListEquiposViewModel>(){
                    ListEquiposViewModel(db.equipoDao())
                }
                EquiposScreen(
                    listEquiposViewModel,
                    onNavegarHome = {backStack.add(Routes.Home)},
                    onBack = {backStack.removeLastOrNull()},
                )
            }
        }
        )
}