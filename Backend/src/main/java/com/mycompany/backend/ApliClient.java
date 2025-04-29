/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backend;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author jl4ma
 */
public class ApliClient {
    
    private static final String BASE_URL = "http://tuservidor/api"; // Cambia aquí tu IP o dominio real
    private static final OkHttpClient client = new OkHttpClient();

    public static String getExpediente(String pacienteId) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "/expediente/" + pacienteId)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error al consultar: " + response.code());
            }
            return response.body().string();
        }
    }
    
}
