package com.example.expediente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pacientes")
public class Paciente {
    @Id
    private String id;
    private String nombre;
    private int edad;
    private String curp;

    
}