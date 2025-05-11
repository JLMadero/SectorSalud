package com.example.appsectorsalud.data

import java.util.Date

data class MensajeAgendar(
    val idPaciente: String,
    val idProfesional: String,
    val tipo: String,
    val fecha: Date,
    val jwt: String


) {

    fun toJson(): String {
        return com.google.gson.Gson().toJson(this)
    }
}
