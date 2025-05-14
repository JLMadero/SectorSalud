/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import ProfesionalDAO.IProfesionalDAO;
import ProfesionalDAO.ProfesionalDAO;
import conexion.Conexion;
import conexion.IConexion;

/**
 *
 * @author jl4ma
 */
public class Fachada implements IFachada{
    
    private IConexion conexion;
    IProfesionalDAO pro;
    
    public Fachada(){
        conexion = new Conexion();
        pro = new ProfesionalDAO(conexion);
    }
    @Override
    public void insercion(){
        if(!pro.iniciarSesion("244903")){
            pro.inserciones();
        }else{
            System.out.println("SIN INSERCION");
        }
    }
    
    @Override
    public boolean iniciarSesion(String cedula){
        return pro.iniciarSesion(cedula);
    }
    
}
