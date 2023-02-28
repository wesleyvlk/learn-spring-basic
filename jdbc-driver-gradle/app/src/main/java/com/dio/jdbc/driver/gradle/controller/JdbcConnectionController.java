package com.dio.jdbc.driver.gradle.controller;

import com.dio.jdbc.driver.gradle.service.implementation.JdbcServiceImpl;

import java.sql.Connection;

public class JdbcConnectionController {
    static JdbcServiceImpl connectionJdbc;

    private JdbcConnectionController() {
        new JdbcServiceImpl();
    }

    public static Connection getConnection() {
        return connectionJdbc.connectInJdbc("mysql",
                "localhost",
                "3306",
                "database",
                "user",
                "password");
    }
}
