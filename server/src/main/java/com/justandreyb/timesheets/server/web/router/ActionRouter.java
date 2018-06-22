package com.justandreyb.timesheets.server.web.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.justandreyb.timesheets.server.web.handler.ActionHandler;

@Configuration
public class ActionRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ActionHandler handler) {
        return RouterFunctions.route(
            RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }

}
