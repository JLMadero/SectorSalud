package com.example.appsectorsalud

import com.example.appsectorsalud.data.Respuesta
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("solicitud/recibir")
    suspend fun enviarRespuesta(@Body respuesta: Respuesta)

    @GET("api/expedientes")
    fun getExpedientes(): Call<List<Expediente>>

    @GET("api/expedientes/{pacienteId}")
    fun getExpedientePorId(@Path("pacienteId") pacienteId: String): Call<Expediente>

}