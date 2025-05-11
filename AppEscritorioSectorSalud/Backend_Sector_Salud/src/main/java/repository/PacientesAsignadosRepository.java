/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import model.PacientesAsignados;

public interface PacientesAsignadosRepository extends JpaRepository<PacientesAsignados, Long> {
    List<PacientesAsignados> findByProfesionalCedula(String cedula);
}
