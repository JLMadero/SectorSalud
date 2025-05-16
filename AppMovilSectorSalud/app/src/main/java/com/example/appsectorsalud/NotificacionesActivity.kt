package com.example.appsectorsalud

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsectorsalud.databinding.ActivityNotificacionesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class NotificacionesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificacionesBinding
    private lateinit var adapter: NotificacionesAdapter
    private lateinit var database: DatabaseReference
    private val listaNotificaciones = mutableListOf<String>()
    private val pacienteActualUuid = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NotificacionesAdapter(
            listaNotificaciones,
            onAcceptClick = { mensaje -> aceptarSolicitud(mensaje) },
            onRejectClick = { mensaje -> rechazarSolicitud(mensaje) }
        )
        binding.recyclerNotifications.layoutManager = LinearLayoutManager(this)
        binding.recyclerNotifications.adapter = adapter

        val uid = FirebaseAuth.getInstance().currentUser?.uid
        if (uid == null) {
            Log.e("FirebaseAuth", "Usuario no autenticado")
            return
        }

        database = FirebaseDatabase.getInstance().getReference("Usuarios").child(uid).child("mensajes")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                listaNotificaciones.clear()
                for (dato in snapshot.children) {
                    val tipo = dato.child("tipo").getValue(String::class.java)
                    val fecha = dato.child("fecha").getValue(String::class.java)
                    val pacienteUuid = dato.child("pacienteUuid").getValue(String::class.java)
                    val activo = dato.child("activo").getValue(Boolean::class.java) ?: false
                    
                    if (tipo != null && fecha != null && activo && pacienteUuid == pacienteActualUuid) {
                        listaNotificaciones.add("$tipo - $fecha")
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseDB", "Error al obtener notificaciones: ${error.message}")
            }
        })

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun aceptarSolicitud(mensaje: String) {
        Log.d("Notificaciones", "Solicitud aceptada: $mensaje")
    }

    private fun rechazarSolicitud(mensaje: String) {
        Log.d("Notificaciones", "Solicitud rechazada: $mensaje")
    }
}
