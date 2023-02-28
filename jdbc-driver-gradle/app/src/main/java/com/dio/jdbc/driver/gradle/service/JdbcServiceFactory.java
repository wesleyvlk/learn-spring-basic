package com.dio.jdbc.driver.gradle.service;

import com.dio.jdbc.driver.gradle.model.JdbcLoginPojo;
import com.dio.jdbc.driver.gradle.model.JdbcUrlPojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcServiceFactory implements JdbcService {

    @Override
    public Connection createJdbcConnection(JdbcUrlPojo configUrl,
                                           JdbcLoginPojo configLogin) {
        try {
            String jdbcUrl = String.format("jdbc:%s://%s:%s/%s",
                    configUrl.getDriver(),
                    configUrl.getHost(),
                    configUrl.getPort(),
                    configUrl.getDataBase()
            );
            return DriverManager.getConnection(jdbcUrl,
                    configLogin.getUser(), configLogin.getPassword());
        } catch (SQLException e) {
            throw new JdbcServiceException("\n You are not connected, please check:\n" +
                    " - Are your URL and Login correct?,\n" +
                    " - Is your database online?,\n" +
                    " - Has your JDBC Dependency Driver been implemented?\n " + e
            );
        }
    }
}

class JdbcServiceException extends RuntimeException {

    public JdbcServiceException(String message) {
        super(message);
    }
}