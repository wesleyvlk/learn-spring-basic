package com.dio.usingbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Book getBook() {
        return new Book();
    }
    // <bean id="book" class="com.springbeans.Book"/>

    @Bean
    public AuthorBook getAuthorBook() {
        return new Author();
    }
}
