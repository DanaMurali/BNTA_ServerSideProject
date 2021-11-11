package com.nightowl.config;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource.main")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

    //passing in our datasource Hikari into our JDBC Template
    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
        return new JdbcTemplate((Connection) hikariDataSource);
    }
}


/*
@Bean
    @Primary // need primary here because you can have multiple data sources - denoting this one as the main
    @ConfigurationProperties("app.datasource.main")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    } // this above code expects configuration - we're taking our configuration from application.properties

    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
        return new JdbcTemplate(hikariDataSource);
    } // within jdbc template we can pass a data source

*
*/

