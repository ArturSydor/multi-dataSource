package com.practice.multi_datasource_with_actuator_api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.practice.multi_datasource_with_actuator_api.repository.warehouse",
        entityManagerFactoryRef = "warehouseDbEntityManagerFactory",
        transactionManagerRef = "warehouseDbTransactionManager"
)
public class WareHouseDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.warehouse-db")
    public DataSource wareHouseDataSource() {
        log.debug("Warehouse DataSource");
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JpaVendorAdapter warehouseDbJpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean warehouseDbEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(wareHouseDataSource());
        entityManagerFactory.setJpaVendorAdapter(warehouseDbJpaVendorAdapter());
        entityManagerFactory.setPersistenceUnitName("warehouseEntities");
        entityManagerFactory.setPackagesToScan("com.practice.multi_datasource_with_actuator_api.repository.warehouse.entity");
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        entityManagerFactory.setJpaPropertyMap(properties);
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager warehouseDbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(warehouseDbEntityManagerFactory().getObject());
        return transactionManager;
    }
}
