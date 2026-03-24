package com.example.clubbasket.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.clubbasket.presentation.screens.home.HomeScreen
import com.example.clubbasket.presentation.screens.perfil.PerfilScreen

@Composable
fun NavigationWrapper(){
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    onNavegarPerfil = { backStack.add(Routes.Perfil) }
                )
            }
            entry <Routes.Perfil> {
                PerfilScreen(
                    onNavegarHome = {backStack.add(Routes.Home)},
                    onBack = {backStack.removeLastOrNull()}
                )}
        }
    )
}