package com.example.clubbasquetpasopaso.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.clubbasquetpasopaso.domain.data.firebase.repository.NoticiaRepositoryImpl
import com.example.clubbasquetpasopaso.domain.data.local.database.AppDatabase
import com.example.clubbasquetpasopaso.domain.data.local.repository.EquipoRepositoryImpl
import com.example.clubbasquetpasopaso.presentation.screens.auth.LoginScreen
import com.example.clubbasquetpasopaso.presentation.screens.equipos.AddEditEquipoViewModel
import com.example.clubbasquetpasopaso.presentation.screens.equipos.AddEditEquipoScreen
import com.example.clubbasquetpasopaso.presentation.screens.equipos.EquiposScreen
import com.example.clubbasquetpasopaso.presentation.screens.equipos.ListEquiposViewModel
import com.example.clubbasquetpasopaso.presentation.screens.home.HomeScreen
import com.example.clubbasquetpasopaso.presentation.screens.noticias.ListNoticiasViewModel
import com.example.clubbasquetpasopaso.presentation.screens.noticias.NoticiasScreen
import com.example.clubbasquetpasopaso.presentation.screens.perfil.PerfilScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun NavigationWrapper(db: AppDatabase, auth: FirebaseAuth, firestore: FirebaseFirestore){

    val backStack = rememberNavBackStack(Routes.Login)

    NavDisplay(
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator ()
        ),
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider
        {
            entry<Routes.Login>{
                LoginScreen(
                    onNavegarHome ={backStack.add(Routes.Home)},
                    auth)
            }
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
                    ListEquiposViewModel(EquipoRepositoryImpl(db.equipoDao()))
                }
                EquiposScreen(
                    listEquiposViewModel,
                    onNavegarHome = {backStack.add(Routes.Home)},
                    onBack = {backStack.removeLastOrNull()},
                    onAddEquipo = {backStack.add(Routes.AddEditEquipo(null))},
                    onEditEquipo = {id->backStack.add(Routes.AddEditEquipo(id))}
                )
            }
            entry<Routes.AddEditEquipo>{
                val addEditViewModel = viewModel<AddEditEquipoViewModel>(){
                    AddEditEquipoViewModel(it.id,EquipoRepositoryImpl(db.equipoDao()))
                }
                AddEditEquipoScreen (
                    addEditViewModel,
                    onNavegarHome = {backStack.add(Routes.Home)},
                    onBack = {backStack.removeLastOrNull()}
                )
            }
            entry<Routes.Noticias>{
                val listNoticiasViewModel = viewModel<ListNoticiasViewModel>() {
                    ListNoticiasViewModel(NoticiaRepositoryImpl(firestore))
                }
                NoticiasScreen(
                    listNoticiasViewModel,
                    onNavegarHome = {backStack.add(Routes.Home)},
                    onBack = {backStack.removeLastOrNull()}
                )
            }

        }
        )
}