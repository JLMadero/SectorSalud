package com.example.appsectorsalud

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsectorsalud.data.Notificacion
import com.example.appsectorsalud.databinding.ActivityNotificacionesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class NotificacionesActivity : AppCompatActivity() {

    private lateinit var b: ActivityNotificacionesBinding
    private val lista = mutableListOf<Notificacion>()
    private lateinit var adapter: NotificacionesAdapter
    private lateinit var refMensajes: DatabaseReference
    private val uid get() = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityNotificacionesBinding.inflate(layoutInflater)
        setContentView(b.root)

        //‑‑ Recycler
        adapter = NotificacionesAdapter(lista,
            onAccept = { aceptar(it) },
            onReject = { rechazar(it) }
        )
        b.recyclerNotifications.layoutManager = LinearLayoutManager(this)
        b.recyclerNotifications.adapter = adapter

        //‑‑ Firebase
        if (uid == null) {
            Toast.makeText(this, "Inicia sesión primero", Toast.LENGTH_SHORT).show()
            finish(); return
        }
        refMensajes = FirebaseDatabase.getInstance()
            .getReference("Usuarios")
            .child(uid!!)
            .child("mensajes")

        refMensajes.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                lista.clear()
                snapshot.children.forEach { snap ->
                    val n = snap.getValue(Notificacion::class.java) ?: return@forEach
                    if (n.activo) lista.add(n.apply { id = snap.key ?: "" })
                }
                lista.sortByDescending { it.timestamp }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        b.btnBack.setOnClickListener { finish() }
    }

    private fun aceptar(n: Notificacion) {
        // desactivar y registrar respuesta
        refMensajes.child(n.id).updateChildren(
            mapOf("activo" to false, "respuesta" to "aceptado")
        )
        Toast.makeText(this, "Acceso concedido", Toast.LENGTH_SHORT).show()
    }

    private fun rechazar(n: Notificacion) {
        refMensajes.child(n.id).updateChildren(
            mapOf("activo" to false, "respuesta" to "rechazado")
        )
        Toast.makeText(this, "Solicitud rechazada", Toast.LENGTH_SHORT).show()
    }
}