package com.example.clubbasquetpasopaso.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clubbasquetpasopaso.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(onNavegarHome:()->Unit,
                auth: FirebaseAuth) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = colorResource(R.color.backgroundDark)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(28.dp))
            Image(
                painter = painterResource(id = R.drawable.app_club_basket_logo),
                contentDescription = "Logo App Club Basket",
                modifier = Modifier
                    .size(320.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Bienvenido",
                color = colorResource(R.color.textPrimary),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Inicia sesión para continuar",
                color = colorResource(R.color.textSecondary),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = RoundedCornerShape(14.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = colorResource(R.color.textPrimary)),
                placeholder = {
                    Text(
                        text = "Correo electrónico"
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colorResource(R.color.textPrimary),
                    unfocusedTextColor = colorResource(R.color.textPrimary),
                    focusedContainerColor =
                        colorResource(R.color.fieldContainer)
                        .copy(alpha = 0.95f),
                    unfocusedContainerColor =
                        colorResource(R.color.fieldContainer)
                            .copy(alpha = 0.88f),
                    focusedBorderColor = colorResource(R.color.accentOrangeLogin),
                    unfocusedBorderColor = colorResource(R.color.fieldBorder),
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = RoundedCornerShape(14.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = colorResource(R.color.textPrimary)),
                placeholder = {
                    Text(
                        text = "Password"
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colorResource(R.color.textPrimary),
                    unfocusedTextColor = colorResource(R.color.textPrimary),
                    focusedContainerColor =
                        colorResource(R.color.fieldContainer)
                            .copy(alpha = 0.95f),
                    unfocusedContainerColor =
                        colorResource(R.color.fieldContainer)
                            .copy(alpha = 0.88f),
                    focusedBorderColor = colorResource(R.color.accentOrangeLogin),
                    unfocusedBorderColor = colorResource(R.color.fieldBorder),
                ))
            Spacer(modifier = Modifier.height(28.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                        colorResource(R.color.accentOrangeLogin),
                    contentColor = Color.White
                ),
                onClick = {
                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                        tarea ->
                        if(tarea.isSuccessful){
                            //Navegar a Home
                            onNavegarHome()
                        }else{
                            //Error
                        }
                    }
                },
            ) {
                Text(
                text = "Iniciar sesión",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            )}
        }
    }
}