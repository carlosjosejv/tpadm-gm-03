package com.carlosjimenez.guestnumber.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlosjimenez.guestnumber.R
import com.carlosjimenez.guestnumber.ui.theme.Fondo1
import com.carlosjimenez.guestnumber.ui.theme.GuestNumberTheme
import kotlin.random.Random

@Composable
fun PantallaPrincipal() {

    var numero by remember {
        mutableStateOf("")
    }

    var numeroAleatorio by remember {
        mutableStateOf(
            Random.nextInt(
                1,
                101
            )
        )
    }

    var intentos by remember {
        mutableStateOf(10)
    }

    var mensaje by remember {
        mutableStateOf("Adivina el numero entre 1 y 100")
    }


    Box(modifier = Modifier.fillMaxSize()){
        Image(painter =
        painterResource(id = R.drawable.fondo1),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.imagen1),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "Adivina el Numero",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp
        )

        Text(
            text = "Carlos Jimenez",
            color = Color.Black,
            fontSize = 18.sp
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = numero, onValueChange = {
                    numero = it
                }, modifier = Modifier
                    .weight(1f)
                    .height(80.dp),
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Button(
                onClick = {
                    if(numero.toInt() == numeroAleatorio){
                        mensaje = "¡¡GANASTE!!"
                    } else {
                        intentos -= 1
                        if(intentos < 1){
                            mensaje = "PERDISTE!! - "
                        }else{
                            if(numero.toInt() > numeroAleatorio){
                                mensaje = "El numero es mas bajo"
                            }else{
                                mensaje = "El numero es mas alto"
                            }
                        }
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(80.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Adivinar!",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Text(
            text = mensaje,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Text(
            text = "Intentos restantes: $intentos",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Button(onClick = {
            numeroAleatorio = Random.nextInt(1, 101)
            intentos = 10
            mensaje = "Adivina el numero entre 1 y 100"
        },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = CircleShape,
            modifier = Modifier.size(130.dp)) {
            Text(text = "Reiniciar")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    GuestNumberTheme {
        PantallaPrincipal()
    }
}