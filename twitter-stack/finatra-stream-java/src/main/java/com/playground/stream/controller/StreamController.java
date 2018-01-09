package com.playground.stream.controller;

import com.twitter.concurrent.AsyncStream;
import com.twitter.finatra.http.AbstractController;
import com.twitter.util.Future;
import com.google.inject.Inject;
import com.playground.stream.service.StreamService;

/**
 * Created by renanpalmeira on 31/12/17.
 */
public class StreamController extends AbstractController {

    @Inject
    private StreamService streamService;

    public void configureRoutes() {
        get("/a", request -> streamService.aMethod());

        get("/tweets", request -> AsyncStream.fromFuture(Future.value("pong")));

        get("/ping", request -> Future.value("pong"));
    }

}
