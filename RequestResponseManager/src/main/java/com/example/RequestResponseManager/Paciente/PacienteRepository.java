package com.example.expediente.repository;

import com.example.expediente.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Paciente findByCurp(String curp);
}