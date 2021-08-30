package com.spike.broker;


import com.spike.broker.server.BrokerWsServerVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * date: 2021/8/24
 * author: Spike
 * description:
 */

public class DemoMainVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoMainVerticle.class);

    public static void main(String[] args) {
        LOGGER.info("Demo server starting .");
        Vertx vertx = Vertx.vertx();
        //vertx.deployVerticle(new BrokerWsServerVerticle(),
                // 等服务端部署好之后再部署客户端
        //        next -> vertx.deployVerticle(new WebSocketClientVerticle()));
        vertx.deployVerticle(new BrokerWsServerVerticle());
        LOGGER.info("demo server has been bootstrapped.");
    }

}
