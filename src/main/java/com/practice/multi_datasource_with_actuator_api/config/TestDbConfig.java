package com.practice.multi_datasource_with_actuator_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TestDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.test-db")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
