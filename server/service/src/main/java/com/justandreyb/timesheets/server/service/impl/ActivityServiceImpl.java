package com.justandreyb.timesheets.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.justandreyb.timesheets.server.model.Activity;
import com.justandreyb.timesheets.server.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityService.class);

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public Activity createRandom() {
        Activity activity = new Activity();
        String id = (String) hibernateTemplate.save(activity);
        LOGGER.info("completed {}", id);
        activity.setId(id);
        return activity;
    }

    @Transactional(readOnly = true)
    @Override
    public Activity loadById(String id) {
        return hibernateTemplate.get(Activity.class, id);
    }
}
