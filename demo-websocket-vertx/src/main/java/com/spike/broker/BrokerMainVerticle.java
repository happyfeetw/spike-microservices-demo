package com.spike.broker;

import io.vertx.core.*;

/**
 * date: 2021/8/24
 * author: Spike
 * description: broker启动的入口
 */
public class BrokerMainVerticle extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        //vertx.deployVerticle(new BrokerWsServerVerticle());
        //vertx.setPeriodic(1000,)
    }
}
