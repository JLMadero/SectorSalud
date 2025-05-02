package com.example.RequestResponseManager.Paciente;

import com.example.RequestResponseManager.Paciente.Paciente;
import com.example.RequestResponseManager.Paciente.PacienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Paciente> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Paciente create(@RequestBody Paciente paciente) {
        return repository.save(paciente);
    }

    @GetMapping("/{curp}")
    public Paciente getByCurp(@PathVariable String curp) {
        return repository.findByCurp(curp);
    }
}