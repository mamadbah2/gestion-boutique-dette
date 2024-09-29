package com.sheet.core.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class DatabaseConfig {

    @Value("${config.yml}")
    private String dbType;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        if ("mysql".equals(dbType)) {
            return Persistence.createEntityManagerFactory("mysql-persistence-unit");
        } else if ("postgresql".equals(dbType)) {
            return Persistence.createEntityManagerFactory("postgresql-persistence-unit");
        } else {
            throw new IllegalArgumentException("Database type not supported: " + dbType);
        }
    }
}
