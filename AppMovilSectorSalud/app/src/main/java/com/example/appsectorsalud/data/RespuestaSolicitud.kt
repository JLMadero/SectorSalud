package com.example.appsectorsalud.data

import java.util.Date

data class RespuestaSolicitud(
    val idPaciente: String,
    val nombrePaciente: String,
    val idProfesional: String,
    val tipo: String = "RespuestaSolicitud",
    val respuesta: Boolean,
    val fechaPermiso: Date,
    val jwt: String
)
