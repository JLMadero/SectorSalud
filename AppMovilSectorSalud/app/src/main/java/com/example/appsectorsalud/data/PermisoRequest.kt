package com.example.appsectorsalud.data

data class PermisoRequest(
    val idPaciente:  String,
    val cedula:      String,
    val fechaGeneracion: String
)
