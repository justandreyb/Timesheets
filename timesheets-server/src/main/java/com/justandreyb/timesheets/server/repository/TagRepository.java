package com.justandreyb.timesheets.server.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.justandreyb.timesheets.server.object.bean.Tag;

public interface TagRepository extends ReactiveCrudRepository<Tag, String> {
}
