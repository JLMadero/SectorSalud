/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.servicios;

import fachada.Fachada;
import fachada.IFachada;

/**
 *
 * @author jl4ma
 */
public class Servicios {

    public static void main(String[] args) {
        
        IFachada f = new Fachada();
        f.insercion();
        
        System.out.println(f.iniciarSesion("244903"));
    }
}
