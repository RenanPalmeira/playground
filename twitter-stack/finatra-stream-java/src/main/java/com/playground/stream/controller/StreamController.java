package com.playground.stream.controller;

import com.google.inject.Singleton;
import com.twitter.finatra.http.AbstractController;
import com.twitter.util.Future;

/**
 * Created by renanpalmeira on 31/12/17.
 */
public class StreamController extends AbstractController {

    public void configureRoutes() {
        get("/ping", request -> Future.value("pong"));
    }

}
