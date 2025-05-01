/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backend;

//import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author jl4ma
 */
public class RabbitListener {
//    private static final String QUEUE_NAME = "notificaciones_doctor";
//    private static final String RABBIT_HOST = "localhost"; // Cambia si tu Rabbit está en otro servidor
//
//    public static void startListening() throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost(RABBIT_HOST);
//
//        Connection connection = (Connection) factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String mensaje = new String(delivery.getBody(), "UTF-8");
//            System.out.println("🔔 Nueva notificación: " + mensaje);
//            // Aquí podrías actualizar tu interfaz gráfica si quieres
//        };
//
//        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
//    }
}
