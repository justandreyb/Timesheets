package com.justandreyb.timesheets.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.justandreyb.timesheets.domain.User;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
}
