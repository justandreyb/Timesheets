package com.justandreyb.timesheets.server;

import com.justandreyb.timesheets.server.config.GlobalConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TimesheetsServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimesheetsServer.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GlobalConfiguration.class);
    }

}
