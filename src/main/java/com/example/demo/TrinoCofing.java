package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.demo")
public class TrinoCofing {

    @Bean(name = "trinoTemplate")
    JdbcTemplate trinoTemplate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
//        final String driverClassName = "com.mysql.jdbc.Driver";
//        final String jdbcUrl = "jdbc:mysql://localhost:3306/BI";
//        final String username = "root";
//        final String password = "root";

        final String driverClassName = "io.trino.jdbc.TrinoDriver";
        final String jdbcUrl = "jdbc:trino://localhost:8080";
//        final String jdbcUrl = "jdbc:trino://trino:9090";
        Properties properties = new Properties();
        properties.setProperty("user", "ritik.singh@rakuten.com");
        // Build dataSource manually:
        final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
        final Driver driver = (Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
//        final DataSource dataSource = new SimpleDriverDataSource(driver, jdbcUrl,username,password);
        final DataSource dataSource = new SimpleDriverDataSource(driver, jdbcUrl,properties);
        return new JdbcTemplate(dataSource);
    }


}
