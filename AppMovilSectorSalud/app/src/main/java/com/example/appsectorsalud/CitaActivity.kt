package com.example.appsectorsalud

import android.app.DatePickerDialog
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
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mostrar DatePicker al hacer clic en el EditText de fecha
        binding.editTextFecha.setOnClickListener {
            mostrarDatePicker()
        }

        binding.btnCita.setOnClickListener {
            enviarCita()
        }

        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun mostrarDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val fechaSeleccionada = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
            binding.editTextFecha.setText(fechaSeleccionada)
        }, year, month, day)

        datePicker.show()
    }

    private fun enviarCita() {
        val fechaTexto = binding.editTextFecha.text.toString()
        val idDoctor = binding.editTextIdDoctor.text.toString()
        val uidPaciente = FirebaseAuth.getInstance().currentUser?.uid

        if (fechaTexto.isEmpty() || idDoctor.isEmpty() || uidPaciente == null) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        // Convertir fechaTexto (dd/MM/yyyy) a Date
        val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fecha: Date? = try {
            formato.parse(fechaTexto)
        } catch (e: ParseException) {
            null
        }

        if (fecha == null) {
            Toast.makeText(this, "Formato de fecha inválido", Toast.LENGTH_SHORT).show()
            return
        }

        val mensaje = MensajeAgendar(
            idPaciente = uidPaciente,
            idProfesional = idDoctor,
            tipo = "Agendar cita",
            fecha = fecha,  // ahora sí es tipo Date
            jwt = "mi_token_simulado"
        )

        CoroutineScope(Dispatchers.Main).launch {
            val resultado = RabbitMQSender.enviarMensaje(mensaje.toJson())
            Toast.makeText(this@CitaActivity, if (resultado) "Cita enviada" else "Error al enviar", Toast.LENGTH_SHORT).show()
        }
    }

}
