package edu.dio.firststepsspring;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner {

    @Autowired
    private Scanner scanner;
    private Calculator calculator;

    @Override
    public void run(String... args) {
        System.out.println("Digite os dois números a serem calculados: ");
        int number1 = scanner.nextInt(), number2 = scanner.nextInt();

        System.out.println("Soma: o resultado da soma é " + calculator.sum(number1, number2));
        System.out.println("Subtração: o resultado da subtração é " + calculator.subtract(number1, number2));
        System.out.println("Subtração: o resultado da multiplicação é " + calculator.multiply(number1, number2));
        System.out.println("Subtração: o resultado da divisão é " + calculator.divide(number1, number2));
    }

}
