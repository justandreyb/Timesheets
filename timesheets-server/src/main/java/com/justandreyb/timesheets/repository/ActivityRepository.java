package com.justandreyb.timesheets.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.justandreyb.timesheets.domain.Activity;

@Repository
public interface ActivityRepository extends ReactiveCrudRepository<Activity, String> {
}
