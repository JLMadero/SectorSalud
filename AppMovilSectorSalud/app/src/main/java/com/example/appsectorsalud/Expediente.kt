package com.example.appsectorsalud

data class Expediente(
    val id: String,
    val pacienteId: String,
    val alergias: List<String>,
    val notasAdicionales: String
)