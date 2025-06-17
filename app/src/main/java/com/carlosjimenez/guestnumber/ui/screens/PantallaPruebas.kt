package com.carlosjimenez.guestnumber.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosjimenez.guestnumber.ui.theme.GuestNumberTheme


@Composable
fun PantallaPruebas(){

    var debeCambiarColor by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()){

        Box(modifier = Modifier
            .background(if(debeCambiarColor)
                Color.Blue else
                    Color.Magenta)
            .align(Alignment.BottomStart)
            .size(200.dp))

        Box(modifier = Modifier
            .width(50.dp)
            .height(250.dp)
            .align(Alignment.TopEnd)
            .background(Color.Yellow))

        Box(modifier = Modifier
            .align(Alignment.Center)
            .width(170.dp)
            .height(90.dp)
            .background(Color.Green))

        Button(onClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)) {
            Text(text = "Cambiar Color")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPruebasPreview(){
    GuestNumberTheme {
        PantallaPruebas()
    }
}