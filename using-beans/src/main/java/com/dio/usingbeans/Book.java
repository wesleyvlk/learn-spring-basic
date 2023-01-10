package com.dio.usingbeans;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    public String name;
    public String barCode;

    @Autowired
    AuthorBook authorBook;

    public void display() {
        System.out.println("\n" + this.name + " - " + this.barCode);
        authorBook.displayAuthor();
    }
}
