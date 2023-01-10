package com.dio.usingbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author implements AuthorBook{

    private String name;

    public void displayAuthor() {
        System.out.println(this.name);
    }

}
