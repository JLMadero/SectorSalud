package com.example.appsectorsalud.data

import java.util.Date

data class MensajeRespuestaSolicitud(
    val idPaciente: String,
    val idProfesional: String,
    val tipo: String,
    val booleano: Boolean = false,
    val fecha: Date,
    val jwt: String
){

    fun toJson(): String {
        return com.google.gson.Gson().toJson(this)
    }
}
