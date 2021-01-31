package com.practice.multi_datasource_with_actuator_api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {

    @Bean
    @Primary
    public ChainedTransactionManager chainedTransactionManager(
            @Qualifier("warehouseDbTransactionManager") PlatformTransactionManager warehouseDbTransactionManager,
            @Qualifier("statisticDbTransactionManager") PlatformTransactionManager statisticDbTransactionManager
    ) {
        return new  ChainedTransactionManager(warehouseDbTransactionManager, statisticDbTransactionManager);
    }

}
