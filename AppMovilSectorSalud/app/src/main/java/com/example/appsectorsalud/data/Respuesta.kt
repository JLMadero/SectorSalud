package com.example.appsectorsalud.data

data class Respuesta(
    val idPaciente: String,
    val idProfesional: String,
    val tipo: String = "Respuesta a solicitud de expediente",
    val respuesta: Boolean,
    val fecha: String,
    val jwt: String
){

    fun toJson(): String {
        return com.google.gson.Gson().toJson(this)
    }
}
