package com.spike.demo.verticles.handler;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;

/**
 * date: 2021/8/6
 * author: Spike
 * description:
 */
@Deprecated
public class DemoRequestRoutingHandler implements Handler {

    private final WebClient client = WebClient.create(Vertx.vertx());

    @Override
    public void handle(Object o) {

    }
}
