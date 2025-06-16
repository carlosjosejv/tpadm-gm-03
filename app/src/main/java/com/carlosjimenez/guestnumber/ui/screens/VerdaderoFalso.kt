package com.carlosjimenez.guestnumber.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosjimenez.guestnumber.R
import com.carlosjimenez.guestnumber.ui.theme.GuestNumberTheme
import com.carlosjimenez.guestnumber.ui.theme.Purple40
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

@Composable
fun VerdaderoFalso() {

    data class Pregunta(val pregunta: String, val key: Boolean)

    val preguntasCiencia = listOf(
        Pregunta("La Tierra gira alrededor del Sol.", true),
        Pregunta("El agua hierve a 90 grados Celsius al nivel del mar.", false),
        Pregunta("Los humanos tienen 206 huesos en el cuerpo.", true),
        Pregunta("La electricidad viaja más rápido que la luz.", false),
        Pregunta("Los átomos están formados por protones, neutrones y electrones.", true),
        Pregunta("El ADN es una proteína.", false),
        Pregunta("El sonido necesita un medio para propagarse.", true),
        Pregunta("La Luna tiene su propia luz.", false),
        Pregunta("La fotosíntesis ocurre en las hojas de las plantas.", true),
        Pregunta("El Sol es un planeta.", false)
    )

    //0 - Neutral
    //1 - Correcto
    //2 - Incorrecto
    var acierto by remember {
        mutableStateOf(0)
    }

    var personaje by remember {
        mutableStateOf(R.drawable.imagen1)
    }

    var indice by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(acierto) {
        when(acierto){
            0 -> personaje = R.drawable.imagen1
            1 -> personaje = R.drawable.happy
            2 -> personaje = R.drawable.angry
        }

        if(acierto != 0){
            delay(2000)
            if(preguntasCiencia.size > indice){
                indice += 1
            }
            acierto = 0
        }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter =
        painterResource(id = R.drawable.fondo),
            contentDescription = "Fondo",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .align(Alignment.CenterHorizontally)){

            Image(
                painter =
                painterResource(id = personaje),
                contentDescription = "Imagen principal",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

        }

        ElevatedCard(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {


                Text(
                    text = preguntasCiencia[indice].pregunta,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                ElevatedButton(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                        if(preguntasCiencia[indice].key == true){
                            acierto = 1
                        }else{
                            acierto = 2
                        }
                    },
                    colors = ButtonDefaults.elevatedButtonColors(Color.Green)
                ) {
                    Text(text = "Verdadero", color = Color.White, fontWeight = FontWeight.Bold)
                }

                ElevatedButton(
                    modifier = Modifier.width(200.dp),
                    onClick = {
                        if(preguntasCiencia[indice].key == false){
                            acierto = 1
                        }else{
                            acierto = 2
                        }
                    },
                    colors = ButtonDefaults.elevatedButtonColors(Color.Red)
                ) {
                    Text(text = "Falso", color = Color.White, fontWeight = FontWeight.Bold)
                }

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun VerdaderoFalsoPreview() {
    GuestNumberTheme {
        VerdaderoFalso()
    }
}

