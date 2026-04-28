package com.example.clubbasquetpasopaso.presentation.screens.equipos


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clubbasquetpasopaso.R
import com.example.clubbasquetpasopaso.domain.model.Categoria
import com.example.clubbasquetpasopaso.domain.model.Tipo
import com.example.clubbasquetpasopaso.presentation.components.AppScaffold

const val INPUT_EQUIPO = "input_equipo"
const val BUTTON_INSERT = "insert_equipo"
const val TEXT_CAT = "text_cat"
const val TEXT_TIP = "text_tip"


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditEquipoScreen(addEditViewModel: AddEditEquipoViewModel,
                        onNavegarHome:()->Unit,
                        onBack:()->Unit) {

    //var nombre by remember { mutableStateOf("") }
    var expandedCat by remember { mutableStateOf(false) }
    //var selectedCategoria by remember {
    //    mutableStateOf(addEditViewModel.equipo.value.categoria)
    //}
    var expandedTipo by remember { mutableStateOf(false) }
    //var selectedTipo by remember {
    //    mutableStateOf(addEditViewModel.equipo.value.tipo)
    //}

    var guardarEnable by remember { mutableStateOf(addEditViewModel.validarNombreEquipo()) }

    AppScaffold(
        title = "Equipos",
        idLeft = R.drawable.arrow_back,
        idRight = R.drawable.home_logo,
        onLeftClick = { onBack() },
        onRightClick = { onNavegarHome() },
    ) { modifier ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {

            Text(
                text = if(addEditViewModel.equipo.value.id==null)
                            "Nuevo equipo"
                       else
                            "Editar equipo ${addEditViewModel.equipo.value.id}",
                style = MaterialTheme.typography.headlineMedium
            )
            OutlinedTextField(
                value = addEditViewModel.equipo.value.nombre,
                placeholder = {
                    Text("Nombre del equipo. Mínimo 3 caracteres")
                },
                onValueChange = {
                    addEditViewModel.addNombre(it)
                    guardarEnable=addEditViewModel.validarNombreEquipo()
                },
                label = { Text("Nombre del equipo. Mínimo 3 caracteres") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(INPUT_EQUIPO)
            )
            //Selector de categoria
            ExposedDropdownMenuBox(
                expanded = expandedCat,
                modifier = Modifier.testTag(TEXT_CAT),
                onExpandedChange = {
                    expandedCat = !expandedCat
                }) {
                TextField(
                    value = addEditViewModel.equipo.value.categoria.name,
                    onValueChange = {},
                    readOnly = true,
                    label = {Text("Categoria")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expandedCat)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expandedCat,
                    onDismissRequest = { expandedCat = false }
                ) {
                    Categoria.entries.forEach { categoria ->
                        DropdownMenuItem(
                            text = {Text(categoria.name)},
                            onClick = {
                                //selectedCategoria = categoria
                                addEditViewModel.addCategoria(categoria)
                                expandedCat = false
                            }

                        )
                    }
                }
            }
            //Selector de tipo
            ExposedDropdownMenuBox(
                expanded = expandedTipo,
                modifier = Modifier.testTag(TEXT_TIP),
                onExpandedChange = {
                    expandedTipo = !expandedTipo
                }) {
                TextField(
                    value = addEditViewModel.equipo.value.tipo.name,
                    onValueChange = {},
                    readOnly = true,
                    label = {Text("Tipo")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expandedTipo)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expandedTipo,
                    onDismissRequest = { expandedTipo = false }
                ) {
                    Tipo.entries.forEach { tipo ->
                        DropdownMenuItem(
                            text = {Text(tipo.name)},
                            onClick = {
                                //selectedTipo = tipo
                                addEditViewModel.addTipo(tipo)
                                expandedTipo = false
                            }
                        )
                    }
                }
            }
            //Anyadir Equipo
            Button(
                onClick = {
                    addEditViewModel.addEditEquipo()
                    onBack()
                },
                enabled = guardarEnable,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(BUTTON_INSERT)
            ) {
                Text(
                    text = if(addEditViewModel.equipo.value.id==null)
                        "GUARDAR"
                    else
                        "MODIFICAR",
                    modifier = Modifier.padding(5.dp),
                    fontSize = 20.sp ,
                    fontWeight = FontWeight.Bold)
            }
        }

    }
}