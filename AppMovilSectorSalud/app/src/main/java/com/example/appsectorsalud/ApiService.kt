package com.example.appsectorsalud

import com.example.appsectorsalud.data.Expediente
import com.example.appsectorsalud.data.MensajeRespuestaSolicitud
import com.example.appsectorsalud.data.Profesional
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("api/nuevopaciente/")
    fun enviarPaciente(@Body nuevoPaciente: NuevoPaciente): Call<Void>

    @POST("api/generarAcceso/")
    fun enviarRespuesta(@Body respuesta: MensajeRespuestaSolicitud)

    @GET("api/expedientes/{pacienteId}")
    fun getExpedientePorId(@Path("pacienteId") pacienteId: String): Call<Expediente>

    @GET("api/profesionales")
    fun getProfesionales(): Call<List<Profesional>>

}