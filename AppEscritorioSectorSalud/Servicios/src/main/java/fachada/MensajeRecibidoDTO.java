/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import java.time.LocalDate;

/**
 *
 * @author jl4ma
 */
public class MensajeRecibidoDTO {

    private Long id;

    private String cedulaProfesional;

    private String pacienteUuid;

    private String tipoMensaje;

    private String nombre;

    private LocalDate fechaCita;

    private LocalDate fechaPermiso;

    private boolean respuesta;
    
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacienteUuid() {
        return pacienteUuid;
    }

    public void setPacienteUuid(String pacienteUuid) {
        this.pacienteUuid = pacienteUuid;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalDate getFechaPermiso() {
        return fechaPermiso;
    }

    public void setFechaPermiso(LocalDate fechaPermiso) {
        this.fechaPermiso = fechaPermiso;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "MensajeRecibidoDTO{" + "id=" + id + ", cedulaProfesional=" + cedulaProfesional + ", pacienteUuid=" + pacienteUuid + ", tipoMensaje=" + tipoMensaje + ", nombre=" + nombre + ", fechaCita=" + fechaCita + ", fechaPermiso=" + fechaPermiso + ", respuesta=" + respuesta + '}';
    }

}
