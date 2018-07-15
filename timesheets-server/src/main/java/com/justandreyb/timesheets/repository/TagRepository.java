package com.justandreyb.timesheets.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.justandreyb.timesheets.domain.Tag;

public interface TagRepository extends ReactiveCrudRepository<Tag, String> {
}
