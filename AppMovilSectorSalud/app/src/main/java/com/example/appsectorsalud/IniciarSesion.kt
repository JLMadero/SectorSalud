package com.example.appsectorsalud

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import org.json.JSONObject

class IniciarSesion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnIniciar: Button
    private lateinit var btnRegistrarse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iniciar_sesion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Referencias a la UI
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnIniciar = findViewById(R.id.btn_iniciar)
        btnRegistrarse = findViewById(R.id.btn_registrarse)

        btnIniciar.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT)
                    .show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this, ExpedienteActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this,
                                "Error: ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }

        btnRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }

        rabbitIniciarConsumo()
    }

    fun rabbitIniciarConsumo() {
        RabbitMQConsumer.iniciarConsumo { mensaje ->
            runOnUiThread {
                try {
                    val json = JSONObject(mensaje)

                    val data = mapOf(
                        "fecha" to json.getString("fecha"),
                        "idPaciente" to json.getString("idPaciente"),
                        "idProfesional" to json.getString("idProfesional"),
                        "jwt" to json.getString("jwt"),
                        "tipo" to json.getString("tipo"),
                        "timestamp" to System.currentTimeMillis()
                    )

                    val db = FirebaseDatabase.getInstance()
                    val mensajesRef = db.getReference("mensajes")
                    mensajesRef.push().setValue(data)
                        .addOnSuccessListener {
                            Log.d("RealtimeDB", "Mensaje guardado correctamente")
                        }
                        .addOnFailureListener { e ->
                            Log.e("RealtimeDB", "Error al guardar mensaje", e)
                        }

                } catch (e: Exception) {
                    Log.e("RabbitMQ", "Error al procesar el mensaje JSON", e)
                }
            }
        }
    }
}
