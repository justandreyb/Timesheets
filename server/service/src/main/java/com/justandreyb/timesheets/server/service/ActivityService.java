package com.justandreyb.timesheets.server.service;

import com.justandreyb.timesheets.server.model.Activity;

public interface ActivityService {

    Activity createRandom();

    Activity loadById(String id);

}
