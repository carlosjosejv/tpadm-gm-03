package com.carlosjimenez.guestnumber.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosjimenez.guestnumber.data.Tarea
import com.carlosjimenez.guestnumber.ui.ItemTarea
import com.carlosjimenez.guestnumber.ui.theme.GuestNumberTheme

@Composable
fun ListaTareas(modifier: Modifier = Modifier) {

    var titulo by remember {
        mutableStateOf("")
    }

    var descripcion by remember {
        mutableStateOf("")
    }

    var mostrarDialogo by remember {
        mutableStateOf(false)
    }

    var tareasPendientes by remember {
        mutableStateOf(emptyList<Tarea>())
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(tareasPendientes) {
                ItemTarea(tarea = it, borrar = {
                    val listaNueva = tareasPendientes.toMutableList()
                    listaNueva.remove(it)
                    tareasPendientes = listaNueva
                })
            }
        }

        Button(
            onClick = {
                mostrarDialogo = true
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Text(text = "Agregar Nueva Tarea")
        }

        if (mostrarDialogo) {
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
                    .background(Color.LightGray)
            ) {

                Column(modifier = Modifier.align(Alignment.Center)) {
                    TextField(value = titulo, onValueChange = {
                        titulo = it
                    }, label = {
                        Text(text = "Titulo")
                    })

                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(value = descripcion, onValueChange = {
                        descripcion = it
                    }, label = {
                        Text(text = "Descripción")
                    })

                    Button(onClick = {
                        val tarea = Tarea(
                            titulo = titulo,
                            descripcion = descripcion
                        )

                        val listaTemporal: MutableList<Tarea> = tareasPendientes.toMutableList()
                        listaTemporal.add(tarea)

                        tareasPendientes = listaTemporal

                        mostrarDialogo = false

                        titulo = ""
                        descripcion = ""
                    }, enabled = (titulo != "" && descripcion != "")) {
                        Text(text = "Guardar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false, backgroundColor = 0xFFFFC107)
@Composable
fun ListaTareasPreview() {
    GuestNumberTheme {
        ListaTareas()
    }
}
