package com.example.appsectorsalud

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appsectorsalud.databinding.ActivityCitaBinding
import com.example.appsectorsalud.databinding.ActivityExpedienteBinding

class CitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_cita)
        binding.navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment_activity_cita)
        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }
}