package com.example.ejemplonavegacion.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.ejemplonavegacion.screens.HomeScreen
import com.example.ejemplonavegacion.screens.JugadorScreen
import kotlinx.serialization.Serializable

@Composable
fun NavigationWrapper() {

    //val backStack = remember { mutableStateListOf<Any>(Home) }
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider =entryProvider {
            entry<Routes.Home>{
                HomeScreen { id->
                    backStack.add(Routes.Detalle(id))
                }
            }
            entry<Routes.Detalle>{ key ->
                JugadorScreen(key.id){
                    backStack.removeLastOrNull()
                }
            }
            entry<Routes.Error>{
                Text("Ruta desconocida")
            }
        }
        /*
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    HomeScreen { id->
                        backStack.add(Detalle(id))
                    }
                }
                is Detalle -> NavEntry(key){
                    JugadorScreen(key.id){
                        backStack.removeLastOrNull()
                    }
                }
                else -> NavEntry(Error) { Text("Ruta desconocida") }
            }
        }*/
    )
}