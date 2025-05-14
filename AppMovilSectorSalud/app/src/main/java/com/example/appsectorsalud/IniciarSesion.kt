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
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

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

        auth = FirebaseAuth.getInstance()

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnIniciar = findViewById(R.id.btn_iniciar)
        btnRegistrarse = findViewById(R.id.btn_registrarse)

        btnIniciar.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val userId = auth.currentUser?.uid
                            if (userId != null) {
                                val dbRef = FirebaseDatabase.getInstance().getReference("Usuarios").child(userId)
                                dbRef.get().addOnSuccessListener { snapshot ->
                                    val fechaNacimientoStr = snapshot.child("fechaNacimiento").value?.toString()

                                    if (fechaNacimientoStr != null) {
                                        try {
                                            val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                            val fechaNacimiento = formato.parse(fechaNacimientoStr)

                                            val hoy = Calendar.getInstance()
                                            val nacimiento = Calendar.getInstance()
                                            nacimiento.time = fechaNacimiento!!

                                            var edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR)
                                            if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
                                                edad--
                                            }

                                            if (edad >= 18) {
                                                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                                                startActivity(Intent(this, ExpedienteActivity::class.java))
                                            } else {
                                                Toast.makeText(this, "Menor de edad. Requiere verificación del tutor.", Toast.LENGTH_SHORT).show()
                                                startActivity(Intent(this, HuellaTutor::class.java))
                                            }
                                            finish()

                                        } catch (e: Exception) {
                                            Log.e("Edad", "Error al analizar fecha de nacimiento", e)
                                            Toast.makeText(this, "Error al leer fecha de nacimiento", Toast.LENGTH_LONG).show()
                                        }
                                    } else {
                                        Toast.makeText(this, "No se encontró la fecha de nacimiento", Toast.LENGTH_LONG).show()
                                    }
                                }.addOnFailureListener {
                                    Toast.makeText(this, "Error al obtener datos del usuario", Toast.LENGTH_LONG).show()
                                }
                            }
                        } else {
                            Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_LONG).show()
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

                    val userId = FirebaseAuth.getInstance().currentUser?.uid

                    if (userId == null) {
                        Log.e("RabbitMQ", "Usuario no autenticado")
                        return@runOnUiThread
                    }

                    val data = mapOf(
                        "fecha" to json.getString("fecha"),
                        "idPaciente" to json.getString("idPaciente"),
                        "idProfesional" to json.getString("idProfesional"),
                        "jwt" to json.getString("jwt"),
                        "tipo" to json.getString("tipo"),
                        "timestamp" to System.currentTimeMillis()
                    )

                    val db = FirebaseDatabase.getInstance()
                    val mensajesRef = db.getReference("Usuarios").child(userId).child("mensajes")
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
