package com.spike.broker.handler;

import io.vertx.core.Context;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.ServerWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;

/**
 * date: 2021/8/24
 * author: Spike
 * description: 处理websocket链接的handler
 */
public class BrokerWebSocketHandler implements Handler<ServerWebSocket> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrokerWebSocketHandler.class);

    private final Vertx vertx;

    public BrokerWebSocketHandler(Vertx vertx) {
        this.vertx = vertx;
    }

    /**
     * Something has happened, so handle it.
     *
     * @param socket the event to handle
     */
    @Override
    public void handle(final ServerWebSocket socket) {

        Context context = vertx.getOrCreateContext();
        if (context.isEventLoopContext()) {
            LOGGER.info("Context attached to Event Loop");
        } else if (context.isWorkerContext()) {
            LOGGER.info("Context attached to Worker Thread");
        } else if (! Context.isOnVertxThread()) {
            LOGGER.info("Context not attached to a thread managed by vert.x");
        }

        // send response to client on connection.
        socket.writeTextMessage("Hello websocket from vertx.");

        // push something periodically
        long timerId = vertx.setPeriodic(5000, id -> {
            socket.writeTextMessage("Current Time is: " + LocalDateTime.now());
        });

        LOGGER.info("A new periodic timer has been set, timer id: {}" , timerId);
        // todo overrided timerId. need to be seperated.
        context.put("timerId",timerId);
        socket.closeHandler(new ServerSocketCloseHandler(vertx));
    }
}
