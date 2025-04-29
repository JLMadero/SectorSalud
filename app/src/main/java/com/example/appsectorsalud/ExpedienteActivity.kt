package com.example.appsectorsalud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appsectorsalud.databinding.ActivityExpedienteBinding

class ExpedienteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpedienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpedienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_expediente)
        binding.navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment_activity_expediente)
        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }
}
