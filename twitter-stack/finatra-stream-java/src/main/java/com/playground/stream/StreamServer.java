package com.playground.stream;

import com.twitter.finatra.http.AbstractHttpServer;
import com.twitter.finatra.http.routing.HttpRouter;
import com.playground.stream.controller.StreamController;

/**
 * Created by renanpalmeira on 31/12/17.
 */
class StreamServerConfiguration extends AbstractHttpServer {

    @Override
    public void configureHttp(HttpRouter httpRouter) {
        httpRouter
                .add(StreamController.class);
    }

}

public final class StreamServer {
    private StreamServer() { }

    public static void main(String[] args) {
        new StreamServerConfiguration().main(args);
    }
}
