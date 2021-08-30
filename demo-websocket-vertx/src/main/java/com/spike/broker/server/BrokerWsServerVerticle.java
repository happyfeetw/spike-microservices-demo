package com.spike.broker.server;

import com.spike.broker.handler.BrokerWebSocketHandler;
import io.vertx.core.*;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * date: 2021/8/24
 * author: Spike
 * description:
 */
public class BrokerWsServerVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrokerWsServerVerticle.class);
    /**
     * If your verticle does a simple, synchronous start-up then override this method and put your start-up
     * code in here.
     *
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        startWsServer(vertx);
    }

    private void startWsServer(Vertx vertx) {
        LOGGER.info("websocket server starting.");
        HttpServerOptions opts = new HttpServerOptions().setHost("localhost")
                .setPort(9527)
                .setWebSocketClosingTimeout(120);// seconds
        HttpServer server = vertx.createHttpServer(opts);
        server.webSocketHandler(new BrokerWebSocketHandler(vertx)).listen();
        LOGGER.info("websocket server started.");
    }
}
