/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import ProfesionalDAO.IProfesionalDAO;
import ProfesionalDAO.ProfesionalDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import conexion.Conexion;
import conexion.IConexion;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import model.Profesional;
import org.eclipse.persistence.internal.libraries.asm.TypeReference;

/**
 *
 * @author jl4ma
 */
public class Fachada implements IFachada {

    private IConexion conexion;
    IProfesionalDAO pro;

    public Fachada() {
        conexion = new Conexion();
        pro = new ProfesionalDAO(conexion);
    }

    @Override
    public void insercion() {
        if (!pro.iniciarSesion("244903")) {
            pro.inserciones();
        } else {
            System.out.println("SIN INSERCION");
        }
    }

    @Override
    public boolean iniciarSesion(String cedula) {
        return pro.iniciarSesion(cedula);
    }

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<MensajeRecibidoDTO> obtenerMensajesPorCedula(String cedula) {
        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/mensajes/profesional/" + cedula))
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta fue exitosa (código 200 OK)
            if (response.statusCode() == 200) {
                // Deserializar la respuesta JSON a una lista de objetos DTO
                return mapper.readValue(response.body(), new com.fasterxml.jackson.core.type.TypeReference<List<MensajeRecibidoDTO>>() {
                });
            } else {
                // Manejo de error si la respuesta no es exitosa
                System.err.println("Error al obtener los mensajes. Código de respuesta: " + response.statusCode());
                return Collections.emptyList();
            }

        } catch (IOException e) {
            // Manejo de excepciones de entrada/salida
            e.printStackTrace();
            return Collections.emptyList();
        } catch (InterruptedException e) {
            // Manejo de interrupciones de hilo
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Profesional obtenerProfesional(String cedula) {
        return pro.getProfesionalCedula(cedula);
    }

}
