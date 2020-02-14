package com.justandreyb.timesheets.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.justandreyb.timesheets.server.database.config.DatabaseConfiguration;
import com.justandreyb.timesheets.server.service.config.ServicesConfiguration;

@Configuration(value = "serverConfiguration")
@PropertySource("classpath:application.properties")
@Import({
    DatabaseConfiguration.class,
    ServicesConfiguration.class,
})
public class GlobalConfiguration {

}
