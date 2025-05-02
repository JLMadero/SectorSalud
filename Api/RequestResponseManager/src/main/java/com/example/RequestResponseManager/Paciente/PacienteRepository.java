package com.example.RequestResponseManager.Paciente;

import com.example.RequestResponseManager.Paciente.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    Paciente findByCurp(String curp);
}