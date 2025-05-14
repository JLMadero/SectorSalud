/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

/**
 *
 * @author jl4ma
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.RabbitMQSenderService;

@SpringBootApplication
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository") 
@ComponentScan(basePackages = "service") // Asegúrate de que el paquete 'service' esté siendo escaneado
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
   

//    // Este método será ejecutado al iniciar la aplicación
//    @Bean
//    public CommandLineRunner demo(RabbitMQSenderService senderService) {
//        return (args) -> {
//            // Enviar un mensaje directamente desde el main para probar
//            senderService.enviarSolicitudExpediente("12345", "abcd-1234");
//            System.out.println("Mensaje enviado a la cola Cliente/Servidor");
//        };
//    }
    
}
