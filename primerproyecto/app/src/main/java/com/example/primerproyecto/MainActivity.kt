package com.example.primerproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.primerproyecto.ui.theme.PrimerproyectoTheme

import android.util.Log //Incluido la librería para usar Logs

class MainActivity : ComponentActivity() {
    // TAG de la aplicación
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "Aplicacion principal creada")

        enableEdgeToEdge()
        setContent {
            PrimerproyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Aplicacion principal iniciada")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Aplicacion principal reanudada")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Aplicacion principal reiniciada")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Aplicacion principal pausada")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Aplicacion principal detenida")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Aplicacion principal destruida")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerproyectoTheme {
        Greeting("Android")
    }
}