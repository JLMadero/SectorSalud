package com.example.appsectorsalud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificacionesAdapter(
    private val listaNotificaciones: List<String>,
    private val onAcceptClick: (String) -> Unit,
    private val onRejectClick: (String) -> Unit
) : RecyclerView.Adapter<NotificacionesAdapter.NotificacionViewHolder>() {

    class NotificacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mensaje: TextView = itemView.findViewById(R.id.tvNotificationMessage)
        val btnAceptar: Button = itemView.findViewById(R.id.btnAccept)
        val btnRechazar: Button = itemView.findViewById(R.id.btnReject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificacionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return NotificacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificacionViewHolder, position: Int) {
        val doctorNombre = listaNotificaciones[position]
        holder.mensaje.text = "El doctor: $doctorNombre quiere ver tu expediente"

        holder.btnAceptar.setOnClickListener { onAcceptClick(doctorNombre) }
        holder.btnRechazar.setOnClickListener { onRejectClick(doctorNombre) }
    }

    override fun getItemCount(): Int = listaNotificaciones.size
}
