package com.spike.demo;

import com.spike.demo.verticles.client.HttpClientVerticle;
import com.spike.demo.verticles.server.BasicHttpServerVerticle;
import com.spike.demo.verticles.server.RouterHttpServerVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class MainVerticel {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticel.class);

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        //vertx.deployVerticle(new HttpClientVerticle());
        vertx.deployVerticle(new RouterHttpServerVerticle());
        vertx.deployVerticle(new BasicHttpServerVerticle());
        LOGGER.info("Vertx start running.");
    }
}
