package com.example.appsectorsalud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appsectorsalud.databinding.ActivityExpedienteBinding
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExpedienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpedienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpedienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_expediente)
        binding.navView.setupWithNavController(navController)

        val pacienteId = "12347"

        ApiClient.instance.getExpedientePorId(pacienteId).enqueue(object : Callback<Expediente> {
            override fun onResponse(call: Call<Expediente>, response: Response<Expediente>) {
                if (response.isSuccessful) {
                    val expediente = response.body()
                    Log.d("API_RESPONSE", "Expediente: $expediente")
                } else {
                    Log.e("API_ERROR", "Código de error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Expediente>, t: Throwable) {
                Log.e("API_FAILURE", "Error: ${t.message}")
            }
        })

        ApiClient.instance.getExpedientes().enqueue(object : Callback<List<Expediente>> {
            override fun onResponse(call: Call<List<Expediente>>, response: Response<List<Expediente>>) {
                if (response.isSuccessful) {
                    val expedientes = response.body()
                    expedientes?.forEach { expediente ->
                        Log.d("API_EXPEDIENTES", """
                    ID: ${expediente.id}
                    Paciente ID: ${expediente.pacienteId}
                    Alergias: ${expediente.alergias.joinToString(", ")}
                    Notas: ${expediente.notasAdicionales}
                """.trimIndent())
                    }
                } else {
                    Log.e("API_ERROR", "Código de error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Expediente>>, t: Throwable) {
                Log.e("API_FAILURE", "Error: ${t.message}")
            }
        })
    }


    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment_activity_expediente)
        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }
}
