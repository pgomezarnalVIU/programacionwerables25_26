package com.example.estadocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.estadocompose.ui.theme.EstadocomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var clicks=0
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadocomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //HelloContent(Modifier.padding(innerPadding))
                    HelloScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun HelloScreen(modifier: Modifier = Modifier){
    //var name by remember() { mutableStateOf("") }
    var name by rememberSaveable () { mutableStateOf("") }

    HelloContent(name,modifier,onNameChange={name=it})
}

@Composable
private fun HelloContent(name:String,
                         modifier: Modifier = Modifier,
                         onNameChange:(String)->Unit) {
    Column(modifier = modifier) {
        Text(
            text = "Hola $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}

/*@Composable
private fun HelloContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        //var name = "Paco"
        // val (name, setName) = remember { mutableStateOf("") }
        var name by remember() { mutableStateOf("") }
        Text(
            text = "Hola $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it},
            label = { Text("Name") }
        )
    }
}*/
