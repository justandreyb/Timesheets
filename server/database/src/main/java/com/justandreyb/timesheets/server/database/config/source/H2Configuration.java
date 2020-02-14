package com.justandreyb.timesheets.server.database.config.source;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("h2")
public class H2Configuration {

    @Bean
    public DataSource baseDataSource(Environment environment) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("database.source.h2.driver"));
        dataSource.setUrl(environment.getRequiredProperty("database.source.h2.url"));
        dataSource.setUsername(environment.getRequiredProperty("database.source.h2.username"));
        dataSource.setPassword(environment.getRequiredProperty("database.source.h2.password"));
        return dataSource;
    }

}
