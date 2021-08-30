package com.spike.broker.handler;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * date: 2021/8/25
 * author: Spike
 * description:
 */
public class ServerSocketCloseHandler implements Handler<Void> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerSocketCloseHandler.class);

    private final Vertx vertx;

    public ServerSocketCloseHandler(Vertx vertx) {
        this.vertx = vertx;
    }

    /**
     * Something has happened, so handle it.
     *
     * @param event the event to handle
     */
    @Override
    public void handle(Void event) {
        if (vertx.getOrCreateContext().isEventLoopContext()) {
            Long timerId = vertx.getOrCreateContext().get("timerId");
            if (vertx.cancelTimer(timerId)) {
                LOGGER.info("Timer-{} has been removed.",timerId);
            }
        }
    }
}
