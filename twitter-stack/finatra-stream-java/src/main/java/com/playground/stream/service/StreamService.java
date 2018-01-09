package com.playground.stream.service;

import com.google.inject.Singleton;
import com.twitter.util.Future;

@Singleton
public class StreamService {
    public Future<String> aMethod() {
        return Future.value("renan");
    }
}