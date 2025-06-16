package com.carlosjimenez.guestnumber.vm

import androidx.lifecycle.ViewModel
import com.carlosjimenez.guestnumber.data.Tarea
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListaViewModel: ViewModel() {

    private val _tareasPendientes =
        MutableStateFlow<MutableList<Tarea>>(mutableListOf())

    val tareasPendientes : StateFlow<MutableList<Tarea>> = _tareasPendientes


}