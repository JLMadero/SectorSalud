package com.example.appsectorsalud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class RegistrarseActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrarse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = Firebase.auth

        val et_nombres: EditText = findViewById(R.id.et_nombres)
        val et_apellido_paterno: EditText = findViewById(R.id.et_apellido_paterno)
        val et_apellido_materno: EditText = findViewById(R.id.et_apellido_materno)
        val et_curp: EditText = findViewById(R.id.et_curp)
        val et_email: EditText = findViewById(R.id.et_email)
        val et_fecha_nacimiento: EditText = findViewById(R.id.et_fecha_nacimiento)
        val et_password: EditText = findViewById(R.id.et_password)

        val btn_sign_in = findViewById(R.id.btn_registrarse) as Button

        et_fecha_nacimiento.setOnClickListener {
            val datePicker = DatePickerFragment()
            datePicker.setOnDateSetListener { _, year, month, dayOfMonth ->
                val fecha = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                et_fecha_nacimiento.setText(fecha)
            }
            datePicker.show(supportFragmentManager, "datePicker")
        }

        btn_sign_in.setOnClickListener {
            val nombres = et_nombres.text.toString()
            val apellidoPaterno = et_apellido_paterno.text.toString()
            val apellidoMaterno = et_apellido_materno.text.toString()
            val curp = et_curp.text.toString()
            val fechaNacimiento = et_fecha_nacimiento.text.toString()
            val email = et_email.text.toString()
            val password = et_password.text.toString()

            if (nombres.isBlank() || apellidoPaterno.isBlank() || apellidoMaterno.isBlank()
                || curp.isBlank() || fechaNacimiento.isBlank() || email.isBlank() || password.isBlank()
            ) {
                Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT)
                    .show()
            } else if (password.length < 6) {
                Toast.makeText(
                    this,
                    "La contraseña debe tener al menos 6 caracteres",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                signUp(
                    nombres,
                    apellidoPaterno,
                    apellidoMaterno,
                    curp,
                    fechaNacimiento,
                    email,
                    password
                )
            }
        }

    }

    private fun showDatePickerDialog() {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun signUp(
        nombres: String,
        apellidoPaterno: String,
        apellidoMaterno: String,
        curp: String,
        fechaNacimiento: String,
        email: String,
        password: String
    ) {
        val database = FirebaseDatabase.getInstance()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    val usuario = mapOf(
                        "usuarioId" to user!!.uid,
                        "nombres" to nombres,
                        "apellidoPaterno" to apellidoPaterno,
                        "apellidoMaterno" to apellidoMaterno,
                        "curp" to curp,
                        "fechaNacimiento" to fechaNacimiento,
                        "email" to email
                    )

                    // Guardar en Realtime Database
                    val reference = database.getReference("Usuarios")
                    reference.child(user.uid).setValue(usuario)
                        .addOnSuccessListener {
                            Toast.makeText(
                                this,
                                "Usuario registrado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, ExpedienteActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                this,
                                "Error al guardar en Realtime Database",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                } else {
                    Toast.makeText(
                        this,
                        "El registro falló: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}