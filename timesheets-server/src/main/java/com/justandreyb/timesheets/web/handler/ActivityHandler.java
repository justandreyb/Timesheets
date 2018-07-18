package com.justandreyb.timesheets.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.justandreyb.timesheets.domain.Tag;
import com.justandreyb.timesheets.repository.TagRepository;

import reactor.core.publisher.Mono;

@Component
public class ActionHandler {

    @Autowired
    private TagRepository repository;

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Spring!"));
    }

}
