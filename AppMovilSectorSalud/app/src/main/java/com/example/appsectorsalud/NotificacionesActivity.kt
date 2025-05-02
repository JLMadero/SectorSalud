package com.example.appsectorsalud

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appsectorsalud.databinding.ActivityExpedienteBinding
import com.example.appsectorsalud.databinding.ActivityNotificacionesBinding

class NotificacionesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificacionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_notificaciones)
        binding.navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment_activity_notificaciones)
        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }
}