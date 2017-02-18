package com.rkaneko.rest;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;

public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }
}
