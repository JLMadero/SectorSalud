package com.example.appsectorsalud

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // El usuario debe autentificarse para poder guardar en la firestore, falta solucinar eso
        btnLogin.setOnClickListener {
            startActivity(Intent(this, ExpedienteActivity::class.java))
            finish()
        }

        val btnSignIn = findViewById<Button>(R.id.btnSignIn)

        btnSignIn.setOnClickListener{
            startActivity(Intent(this, RegistrarseActivity::class.java))
        }
    }


}