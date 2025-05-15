/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author jl4ma
 */
@Entity
public class MensajeRecibido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cedulaProfesional;
    
    private String pacienteUuid;

    private String tipoMensaje;

    private String nombre;
    
    private LocalDate fechaCita;
    
    private LocalDate fechaPermiso;
    
    private boolean respuesta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
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

    public String getPacienteUuid() {
        return pacienteUuid;
    }

    public void setPacienteUuid(String pacienteUuid) {
        this.pacienteUuid = pacienteUuid;
    }

    
    
    
}