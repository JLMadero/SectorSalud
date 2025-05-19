package com.example.appsectorsalud.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PermisoRequest(
    val idPaciente:  String,
    val cedula:      String,
    @SerializedName("fechaDeGeneracion")
    val fechaDeGeneracion: String
)
