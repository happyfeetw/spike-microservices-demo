package com.spike.broker.handler;

import io.vertx.core.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * date: 2021/8/24
 * author: Spike
 * description:
 */
public class WebSocketTextMessageHandler implements Handler<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketTextMessageHandler.class);
    /**
     * Something has happened, so handle it.
     *
     * @param textMsg the event to handle
     */
    @Override
    public void handle(String textMsg) {
        LOGGER.info("Server {}", textMsg);
    }
}
