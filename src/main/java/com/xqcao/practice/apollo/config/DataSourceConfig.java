package com.xqcao.practice.apollo.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private org.springframework.cloud.context.scope.refresh.RefreshScope refreshScope;

    @ApolloConfigChangeListener("db")
    private void onChange(ConfigChangeEvent changeEvent) {
        final boolean match = changeEvent.changedKeys().stream().anyMatch(s -> s.contains("spring.datasource"));
        if (match) {
            log.info("change the data source config: {}", changeEvent.changedKeys());
            applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
            refreshScope.refresh("dataSource");
        }
    }

    @Bean
    @RefreshScope
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        log.info("using data source properties: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
