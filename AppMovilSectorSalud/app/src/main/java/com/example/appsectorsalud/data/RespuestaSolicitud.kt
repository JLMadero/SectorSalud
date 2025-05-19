package com.example.appsectorsalud.data

import com.google.gson.Gson
import java.util.Date

data class RespuestaSolicitud(
    val idPaciente: String,
    val nombrePaciente: String,
    val cedula: String,
    val tipo: String = "RespuestaSolicitud",
    val respuesta: Boolean,
    val fecha_permiso: String,
    val jwt: String
) {
    fun toJson(): String = Gson().toJson(this)
}