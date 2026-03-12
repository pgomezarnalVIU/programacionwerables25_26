package com.example.ejemploslayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.tappableElementIgnoringVisibility
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemploslayouts.ui.theme.EjemplosLayoutsTheme

class LayoutsBasicos : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemplosLayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .width(300.dp)
                                .height(300.dp)
                                .border(width = 2.dp, Color.Red)
                                .padding(bottom = 10.dp)
                        ) {
                            CajaTexto("1", R.color.teal_200)
                            CajaTexto("2", R.color.teal_700)
                            CajaTexto("3", R.color.purple_200)
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .width(300.dp)
                                .height(300.dp)
                                .border(width = 2.dp, Color.Red)
                        ){
                            CajaTexto("1", R.color.teal_200)
                            CajaTexto("2", R.color.teal_700)
                            Text(
                                "2b",
                                fontSize = 28.sp,
                                modifier = Modifier
                                    .background(colorResource(R.color.purple_500))
                                    .padding(30.dp)
                                    .fillMaxWidth()
                            )
                            CajaTexto("3", R.color.purple_200)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CajaTexto(texto: String, color: Int){
    Text(
        texto,
        fontSize = 28.sp,
        modifier = Modifier
            .background(colorResource(color))
            .padding(30.dp)
    )
}
