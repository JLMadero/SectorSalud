/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import java.util.List;

/**
 *
 * @author jl4ma
 */
public interface IFachada {
    
    public void insercion();
    public boolean iniciarSesion(String cedula);
    public List<MensajeRecibidoDTO> obtenerMensajesPorCedula(String cedula);
}
