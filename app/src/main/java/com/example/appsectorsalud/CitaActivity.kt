package com.example.appsectorsalud

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)

        findViewById<Button>(R.id.btnSolicitarCita).setOnClickListener {
            Toast.makeText(this, "Cita solicitada con el Dr. Pérez", Toast.LENGTH_LONG).show()
        }
    }
}