package com.justandreyb.timesheets.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration(value = "serverConfiguration")
@PropertySource("application.properties")
@Import(DatabaseConfiguration.class)
public class GlobalConfiguration {

}
