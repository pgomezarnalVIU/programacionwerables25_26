package com.example.ejemploslayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemploslayouts.ui.theme.EjemplosLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemplosLayoutsTheme {
               Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Column(modifier = Modifier.padding(innerPadding)) {
                       TextoModificado("Titulo")
                       Text("Una prueba de texto",
                           color=Color.Cyan,
                           fontSize = 24.sp,
                           fontWeight = FontWeight.Bold)
                       TextoModificado("Titulo 2")
                       TextoEstilo("Paco")
                       TextoEstilo("Profesor informática")
                       TextoRectangulo("Profesor en VIU")
                   }
                   /*
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun TextoModificado(texto: String){
    Text(texto,
        color=Color.Magenta,
        fontSize = 28.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.W600
    )
}

@Composable
fun TextoEstilo(texto:String){
    Text(texto,
        style=TextStyle(
            color=Color.Blue,
            fontSize = 22.sp,
            fontWeight = FontWeight.W200,
            fontFamily = FontFamily.SansSerif,
            background = Color.LightGray),
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun TextoRectangulo(texto:String){
    Text(texto,
        modifier = Modifier
            .background(Color.LightGray)
            .padding(10.dp)
    )
}