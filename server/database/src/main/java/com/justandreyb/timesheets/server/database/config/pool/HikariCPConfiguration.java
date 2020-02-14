package com.justandreyb.timesheets.server.database.config.pool;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Profile("hikari-cp-pool")
public class HikariCPConfiguration {

    @Bean
    public DataSource dataSource(Environment environment, DataSource dataSource) {
        HikariConfig config = new HikariConfig();
        config.setDataSource(dataSource);
        config.setPoolName(environment.getRequiredProperty("database.pool.hikariCp.poolName"));
        config.setConnectionTestQuery(environment.getRequiredProperty("database.pool.hikariCp.connectionTestQuery"));
        config.setMaximumPoolSize(environment.getRequiredProperty("database.pool.hikariCp.maximumPoolSize", Integer.class));
        config.setConnectionTimeout(environment.getRequiredProperty("database.pool.hikariCp.connectionTimeout", Long.class));
        return new HikariDataSource(config);
    }

}
