/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author jl4ma
 */

import model.MensajesRecibidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRecibidoRepository extends JpaRepository<MensajesRecibidos, Long> {
}
