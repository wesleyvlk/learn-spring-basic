package com.dio.jdbc.driver.gradle.service.implementation;

import com.dio.jdbc.driver.gradle.model.JdbcLoginPojo;
import com.dio.jdbc.driver.gradle.model.JdbcUrlPojo;
import com.dio.jdbc.driver.gradle.service.JdbcServiceFactory;

import java.sql.Connection;

public class JdbcServiceImpl {
    private final JdbcServiceFactory connectionFactory = new JdbcServiceFactory();
    private final JdbcUrlPojo configUrl = new JdbcUrlPojo();
    private final JdbcLoginPojo configLogin = new JdbcLoginPojo();

    public Connection connectInJdbc(String driver,
                                    String ipHost,
                                    String port,
                                    String dataBase,
                                    String user,
                                    String password) {
        configUrl.setDriver(driver);
        configUrl.setHost(ipHost);
        configUrl.setPort(port);
        configUrl.setDataBase(dataBase);
        configLogin.setUser(user);
        configLogin.setPassword(password);
        return connectionFactory.createJdbcConnection(configUrl, configLogin);
    }
}
