package com.example.appsectorsalud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btnExpediente).setOnClickListener {
            startActivity(Intent(this, ExpedienteActivity::class.java))
        }

        findViewById<Button>(R.id.btnCita).setOnClickListener {
            startActivity(Intent(this, CitaActivity::class.java))
        }

        findViewById<Button>(R.id.btnNotificaciones).setOnClickListener {
            startActivity(Intent(this, NotificacionesActivity::class.java))
        }

        findViewById<Button>(R.id.btnAutorizacion).setOnClickListener {
            startActivity(Intent(this, AutorizacionActivity::class.java))
        }
    }
}