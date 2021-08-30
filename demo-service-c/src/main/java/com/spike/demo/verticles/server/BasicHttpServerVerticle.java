package com.spike.demo.verticles.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

/**
 * date: 2021/8/5
 * author: Spike
 * description:
 */
public class BasicHttpServerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer();

        server.requestHandler(request -> {
            HttpServerResponse resp = request.response();
            resp.putHeader("content-type", "text/plain");
            resp.end("Hello this is vertx http server.");
        });

        server.listen(6666);

    }
}