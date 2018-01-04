package com.playground.stream;

import com.playground.stream.controller.StreamController;
import com.twitter.finatra.http.AbstractHttpServer;
import com.twitter.finatra.http.routing.HttpRouter;

/**
 * Created by renanpalmeira on 01/01/18.
 */
public class StreamServerConfiguration extends AbstractHttpServer {

    @Override
    public void configureHttp(HttpRouter httpRouter) {
        httpRouter
                .add(StreamController.class);
    }

}
