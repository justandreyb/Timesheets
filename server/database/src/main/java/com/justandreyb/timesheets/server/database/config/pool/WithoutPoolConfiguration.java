package com.justandreyb.timesheets.server.database.config.pool;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("without-pool")
public class WithoutPoolConfiguration {

    @Bean
    public DataSource dataSource(DataSource dataSource) {
        return dataSource;
    }

}
