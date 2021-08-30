package com.spike.broker.client;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.TimeUnit;

/**
 * date: 2021/8/24
 * author: Spike
 * description: websocket客户端
 */
public class WebSocketClientVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketClientVerticle.class);

    /**
     * If your verticle does a simple, synchronous start-up then override this method and put your start-up
     * code in here.
     *
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        startWebSocketClient(vertx);
    }

    private void startWebSocketClient(Vertx vertx) {
        LOGGER.info("websocket client started.");
        HttpClient client = vertx.createHttpClient();
        client.webSocket(9527,"localhost","/",socket -> {
            if (socket.succeeded()){
                WebSocket webSocket = socket.result();
                webSocket.textMessageHandler(msg -> {
                    LOGGER.info("Client receive: " + msg);
                    webSocket.writeTextMessage("pong from client.");
                }).exceptionHandler(ex -> {
                    LOGGER.info("Closed, restarting in 10 seconds");
                    restart(client, 5);
                }).closeHandler(close -> {
                    LOGGER.info("Closed, restarting in 10 seconds");
                    restart(client, 10);
                });
            }
        });
    }

    private void restart(HttpClient client, int delay) {
        client.close();
        vertx.setTimer(TimeUnit.SECONDS.toMillis(delay), timer -> {
            startWebSocketClient(vertx);
        });
    }
}
