package com.justandreyb.timesheets.server;

import com.justandreyb.timesheets.server.config.GlobalConfiguration;
import com.justandreyb.timesheets.server.model.Activity;
import com.justandreyb.timesheets.server.service.ActivityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TimesheetsServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimesheetsServer.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GlobalConfiguration.class);
        ActivityService service = applicationContext.getBean(ActivityService.class);
        Activity random = service.createRandom();
        Activity load = service.loadById(random.getId());
        LOGGER.info("Result: {}", random.equals(load));
    }

}
