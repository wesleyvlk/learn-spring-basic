package edu.dio.scopessingletonprototypespring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    
    @Bean
    @Scope("prototype")
    public Sender sender() {
        System.out.println("CRIANDO UM OBJETO REMETENTE");
        Sender sender = new Sender();
        sender.setEmail("noreply@dio.com.br");
        sender.setName("Digital Innovation One");
        return sender;
    }
}
