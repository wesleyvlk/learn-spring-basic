package com.dio.jdbc.driver.gradle.service;

import com.dio.jdbc.driver.gradle.model.JdbcLoginPojo;
import com.dio.jdbc.driver.gradle.model.JdbcUrlPojo;

import java.sql.Connection;

interface JdbcService {
    Connection createJdbcConnection(JdbcUrlPojo configUrl,
                                    JdbcLoginPojo configLogin);
}

