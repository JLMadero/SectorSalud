package com.example.appsectorsalud

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AutorizacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autorizacion)

        findViewById<Button>(R.id.btnAutorizar).setOnClickListener {
            Toast.makeText(this, "Acceso autorizado correctamente", Toast.LENGTH_SHORT).show()
        }
    }
}