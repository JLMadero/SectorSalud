/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solicitudes;

/**
 *
 * @author jl4ma
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient client = HttpClient.newHttpClient();
    private final String url = "https://pruebaapi-sv1q.onrender.com/api";
    
    public String getExpedientes() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    
     public String getExpedientePorId(String idPaciente, String cedulaProfesional) throws IOException, InterruptedException {
        // Ajusta los nombres de los parámetros a los que tu API espera: idDocto y idPaciente
        String endpoint = String.format("%s/expediente?idDoctor=%s&idPaciente=%s", url, cedulaProfesional, idPaciente);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
