/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import model.MensajeRecibido;
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
            JsonNode root = objectMapper.readTree(mensajeJson);
            String tipo = root.get("tipo").asText();
//            if ("AgendarCita".equals(tipo)) {
//                
//            }else if("RespuestaSolicitud"){
//                
//            }
            String cedulaProfesional = root.get("cedulaProfesional").asText();
            String pacienteUuid = root.get("pacienteUuid").asText();

            // Procesa el mensaje según el tipo
            if ("SolicitudExpediente".equals(tipo)) {
                // Guardar en la base de datos
                MensajeRecibido mensaje = new MensajeRecibido();
                mensaje.setCedulaProfesional(cedulaProfesional);
                mensaje.setTipoMensaje(tipo);
                mensaje.setContenido(mensajeJson);
                mensajeRepo.save(mensaje);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



