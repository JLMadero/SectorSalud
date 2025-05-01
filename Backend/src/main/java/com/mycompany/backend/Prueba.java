/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backend;

/**
 *
 * @author USER
 */
public class Prueba {
    
    public static void main(String[] args) throws Exception {
        
        ApiClient conexion = new ApiClient();
        System.out.println("Todos los expedientes");
        System.out.println(conexion.getExpedientes());
        System.out.println("Expediente 12347");
        System.out.println(conexion.getExpedientePorId("12347"));
     
        
        
    }
    
}
