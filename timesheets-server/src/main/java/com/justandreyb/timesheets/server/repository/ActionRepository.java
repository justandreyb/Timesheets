package com.justandreyb.timesheets.server.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.justandreyb.timesheets.server.object.bean.Action;

@Repository
public interface ActionRepository extends ReactiveCrudRepository<Action, String> {
}
