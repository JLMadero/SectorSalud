package com.example.appsectorsalud

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/expedientes")
    fun getExpedientes(): Call<List<Expediente>>

    @GET("api/expedientes/{pacienteId}")
    fun getExpedientePorId(@Path("pacienteId") pacienteId: String): Call<Expediente>

}