package com.example.ejemploslayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejemploslayouts.ui.theme.EjemplosLayoutsTheme
import androidx.compose.material3.Icon

class BoxActivityExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemplosLayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    Column(modifier = Modifier.padding(innerPadding)) {
                        AvatarConEstado()
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
fun AvatarConEstado() {
    Box(
        modifier = Modifier.size(72.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(R.drawable.man),
            contentDescription = "Avatar",
            modifier = Modifier.fillMaxSize()
        )
        Icon(
            painter = painterResource(R.drawable.check_circle_24dp),
            contentDescription = null,
            tint = Color(0xFF111827),
            modifier = Modifier.size(24.dp)
        )
    }
}