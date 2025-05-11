package com.example.appsectorsalud

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.TextView as AndroidTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appsectorsalud.databinding.ActivityExpedienteBinding

class ExpedienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpedienteBinding
    private lateinit var patientIdTextView: TextView
    private lateinit var nombreTextView: TextView
    private lateinit var creationDateTextView: TextView
    private lateinit var alergiasList: RecyclerView
    private lateinit var notasList: RecyclerView
    private val pacienteId = "12347"

    // Define the ActivityResultLauncher to handle the result from CitaActivity
    private lateinit var citaActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpedienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        patientIdTextView = findViewById(R.id.patientId)
        nombreTextView = findViewById(R.id.nombre)
        creationDateTextView = findViewById(R.id.creationDate)
        alergiasList = findViewById(R.id.alergiasList)
        notasList = findViewById(R.id.notasList)

        alergiasList.layoutManager = LinearLayoutManager(this)
        notasList.layoutManager = LinearLayoutManager(this)

        // Set up the ActivityResultLauncher to handle the result
        citaActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // If the result is OK, reload the data
                loadExpediente()
            }
        }

        // Set up the button to open CitaActivity
        binding.btnCitas.setOnClickListener {
            val intent = Intent(this, CitaActivity::class.java)
            citaActivityResultLauncher.launch(intent)
        }

        // Initial data load
        loadExpediente()
    }

    private fun loadExpediente() {
        ApiClient.instance.getExpedientePorId(pacienteId).enqueue(object : Callback<Expediente> {
            override fun onResponse(call: Call<Expediente>, response: Response<Expediente>) {
                if (response.isSuccessful) {
                    val expediente = response.body()
                    expediente?.let {
                        patientIdTextView.text = it.pacienteId
                        nombreTextView.text = "Nombre no disponible"
                        creationDateTextView.text = "Fecha no disponible"

                        alergiasList.adapter = SimpleListAdapter(it.alergias ?: listOf("Sin datos"))
                        notasList.adapter = SimpleListAdapter(listOf(it.notasAdicionales ?: "Sin notas"))
                    }
                } else {
                    Log.e("API_ERROR", "Código de error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Expediente>, t: Throwable) {
                Log.e("API_FAILURE", "Error: ${t.message}")
            }
        })
    }

    class SimpleListAdapter(private val items: List<String>) :
        RecyclerView.Adapter<SimpleListAdapter.ViewHolder>() {

        class ViewHolder(val view: TextView) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val textView = TextView(parent.context).apply {
                setPadding(16, 16, 16, 16)
                textSize = 14f
            }
            return ViewHolder(textView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.view.text = items[position]
        }

        override fun getItemCount(): Int = items.size
    }
}
