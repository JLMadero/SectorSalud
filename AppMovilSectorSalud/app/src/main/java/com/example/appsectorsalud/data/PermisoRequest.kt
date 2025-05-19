package com.example.appsectorsalud.data

import java.util.Date

data class PermisoRequest(
    val idPaciente:  String,
    val cedula:      String,
    val fechaDeGeneracion: Date
)
