/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import rabbitConfig.RabbitMQConfig;

/**
 *
 * @author jl4ma
 */
@Service
@RequiredArgsConstructor
public class RabbitMQSenderService {

    private final RabbitTemplate rabbitTemplate;

    public void enviarSolicitudExpediente(String cedulaProfesional, String pacienteUuid) {
        String mensaje = String.format("{\"cedulaProfesional\":\"%s\",\"pacienteUuid\":\"%s\",\"tipo\":\"SolicitudExpediente\"}",
                cedulaProfesional, pacienteUuid);

        // Envío del mensaje a RabbitMQ
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.EXPEDIENTE_ROUTING_KEY, mensaje);
    }
}

