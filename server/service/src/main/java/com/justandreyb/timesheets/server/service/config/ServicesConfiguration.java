package com.justandreyb.timesheets.server.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.justandreyb.timesheets.server.service.ActivityService;
import com.justandreyb.timesheets.server.service.impl.ActivityServiceImpl;

@Configuration("servicesConfiguration")
public class ServicesConfiguration {

    private Environment environment;

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Bean
    public ActivityService activityService() {
        ActivityServiceImpl activityService = new ActivityServiceImpl();
        activityService.setHibernateTemplate(hibernateTemplate);
        return activityService;
    }

}
