package com.justandreyb.timesheets.server.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.justandreyb.timesheets.server.object.bean.User;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
}
