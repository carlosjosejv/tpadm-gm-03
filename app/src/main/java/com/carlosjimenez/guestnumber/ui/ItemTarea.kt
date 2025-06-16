 package com.carlosjimenez.guestnumber.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosjimenez.guestnumber.data.Tarea
import com.carlosjimenez.guestnumber.ui.theme.GuestNumberTheme

@Composable
fun ItemTarea(tarea: Tarea, borrar: () -> Unit = {}){
    
    var completado by remember {
        mutableStateOf(false)
    }

    ElevatedCard(onClick = { /*TODO*/ },
        colors = CardDefaults.
        cardColors(
            if(completado) Color.Green else Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Column(modifier = Modifier.weight(1f)) {
                Text(text = tarea.titulo)
                Text(text = tarea.descripcion,
                    overflow = TextOverflow.Ellipsis)
            }

            Row(modifier = Modifier.padding(2.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = completado,
                    onCheckedChange = {
                        completado = it
                    })

                IconButton(onClick = { borrar() }) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Borrar"
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF3F51B5)
@Composable
fun ItemTareaPreview(){
    GuestNumberTheme {
        ItemTarea(
            Tarea(titulo = "Leer",
                descripcion = "20 minutos"
            )
        )
    }
}