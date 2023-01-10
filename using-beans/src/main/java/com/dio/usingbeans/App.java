package com.dio.usingbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

        Book book = app.getBean(Book.class);
        book.setName("Les Miserables");
        book.setBarCode("J34NV4LJ");

        Author author = app.getBean(Author.class);
        author.setName("Vitor Hugo");
    
        book.display();

        ((AbstractApplicationContext) app).close();
    }
}
