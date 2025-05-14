/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import model.MensajesRecibidos;
import model.PacientesAsignados;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbitConfig.RabbitMQConfig;
import repository.MensajeRecibidoRepository;
import repository.PacientesAsignadosRepository;

/**
 *
 * @author jl4ma
 */
@Service
@RequiredArgsConstructor
public class RabbitMQListenerService {

    private final MensajeRecibidoRepository mensajeRepo;
    private final PacientesAsignadosRepository pacienteRepo;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = RabbitMQConfig.CLIENTE_SERVIDOR_QUEUE)
    public void recibirMensajes(String mensajeJson) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            JsonNode root = objectMapper.readTree(mensajeJson);
            String tipo = root.get("tipo").asText();
            String cedulaProfesional = root.get("cedulaProfesional").asText();
            String pacienteUuid = root.get("pacienteUuid").asText();
            String contenido = root.get("contenido").asText();
            String fecha = root.get("fecha").asText();
            Date fechaCita = formato.parse(fecha);

            // Procesa el mensaje según el tipo
            if ("AvisoAgendacionCita".equals(tipo)) {
                // Guardar en la base de datos
                MensajesRecibidos mensaje = new MensajesRecibidos();
                mensaje.setCedulaProfesional(cedulaProfesional);
                mensaje.setTipoMensaje(tipo);
                mensaje.setContenido(contenido);
                mensajeRepo.save(mensaje);
                PacientesAsignados paciente = new PacientesAsignados();
                paciente.setFecha(fechaCita);
                paciente.setPacienteUuid(pacienteUuid);
                paciente.setProfesionalCedula(pacienteUuid);
                pacienteRepo.save(paciente);
            }else if("RespuestaSolicitudExpediente".equals(tipo)){
                MensajesRecibidos mensaje = new MensajesRecibidos();
                mensaje.setCedulaProfesional(cedulaProfesional);
                mensaje.setTipoMensaje(tipo);
                mensaje.setContenido(contenido);
                mensajeRepo.save(mensaje);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



