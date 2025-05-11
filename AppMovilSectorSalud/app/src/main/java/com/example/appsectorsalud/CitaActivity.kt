package com.example.appsectorsalud

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appsectorsalud.data.MensajeAgendar
import com.example.appsectorsalud.data.Respuesta
import com.example.appsectorsalud.databinding.ActivityCitaBinding
import com.example.appsectorsalud.databinding.ActivityExpedienteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

class CitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mensaje = MensajeAgendar(
            idPaciente = "123",
            idProfesional = "456",
            tipo = "Agendar cita",
            fecha = Date(),
            jwt = "mi_token_simulado"
        )

        CoroutineScope(Dispatchers.Main).launch {
            val resultado = RabbitMQSender.enviarMensaje(mensaje.toJson())
            Toast.makeText(this@CitaActivity, if (resultado) "Enviado" else "Error al enviar", Toast.LENGTH_SHORT).show()
        }
    }
}