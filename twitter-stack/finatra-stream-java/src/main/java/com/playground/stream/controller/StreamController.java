package com.playground.stream.controller;

import com.twitter.concurrent.AsyncStream;
import com.twitter.finatra.http.AbstractController;
import com.twitter.util.Future;

/**
 * Created by renanpalmeira on 31/12/17.
 */
public class StreamController extends AbstractController {

    public void configureRoutes() {
        get("/tweets", request -> AsyncStream.fromFuture(Future.value("pong")));

        get("/ping", request -> Future.value("pong"));
    }

}
