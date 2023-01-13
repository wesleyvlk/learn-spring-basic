package edu.dio.propertiesvaluespring.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageSystem implements CommandLineRunner {

    @Value("${name:NoReply-DIO}")
    private String name;
    @Value("${email}")
    private String email;
    @Value("${phones}")
    private List<Long> phones;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por: " + name
                + "\nE-mail:" + email
                + "\nCom telefones para contato: " + phones);
        System.out.println("Seu cadastro foi aprovado");
    }

}
