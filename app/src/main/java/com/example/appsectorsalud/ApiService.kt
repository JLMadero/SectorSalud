package com.example.appsectorsalud

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("api/citas/agendar")
    fun agendarCita(@Body cita: CitaRequest): Call<Void>

    @GET("api/expedientes/{pacienteId}")
    fun getExpediente(@Path("pacienteId") pacienteId: String): Call<Expediente>

    @POST("api/expedientes/{pacienteId}/autorizar")
    fun autorizarAcceso(
        @Path("pacienteId") pacienteId: String,
        @Query("doctorId") doctorId: String
    ): Call<Void>
}