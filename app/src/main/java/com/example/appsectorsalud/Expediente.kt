package com.example.appsectorsalud

data class Expediente(
    val pacienteId: String,
    val nombre: String,
    val consultas: List<Consulta>,
    val imagenes: List<String>,
    val documentos: List<String>
)

data class Consulta(
    val fecha: String,
    val medico: String,
    val notas: String
)