package com.spike.demo.verticles.server;

import com.spike.demo.entity.User;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.*;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;

import java.nio.charset.StandardCharsets;

/**
 * date: 2021/8/6
 * author: Spike
 * description:
 */
public class RouterHttpServerVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouterHttpServerVerticle.class);

    private final WebClient client = WebClient.create(Vertx.vertx());

    private final String person = "name";

    @Override
    public void start() throws Exception {

        HttpServerOptions serverOpts = new HttpServerOptions();
        serverOpts.setHost("demo.spike.com") // need to add host mapping in /etc/hosts
                .setPort(6667);

        HttpServer server = vertx.createHttpServer(serverOpts);

        Router router = Router.router(vertx);

        Route basicRoute = router.route();
        basicRoute.method(HttpMethod.GET)
                .path("/sayHelloToVertx/:" + person)
                .handler(routingContext -> {

                    HttpServerRequest req = routingContext.request();
                    HttpServerResponse resp = routingContext.response();

                    String absoluteURI = req.absoluteURI();
                    String uri = req.uri();
                    LOGGER.info("Receiving request, absoluteURI: {}, uri: {}", absoluteURI, uri);

                    resp.putHeader("content-type", "text/plain");
                    resp.end("Hello from RouterHttpServer.");

                    String name = req.getParam(person);
                    RequestOptions reqOpts = new RequestOptions();
                    reqOpts.setHost("localhost").setPort(9999).setURI("/greetings/" + name);
                    client.request(HttpMethod.POST, reqOpts).send(ar -> {
                        if (ar.succeeded()) {
                            User user = ar.result().bodyAsJson(User.class);
                            LOGGER.info("Greetings to user: {}", user);
                            //System.out.println("user = " + user);
                        }
                    });
                });

        Route apiRoute = router.route();
        apiRoute.method(HttpMethod.GET)
                .path("/api/SayHelloToVertx/:" + person)
                .handler(routingContext -> {
                    HttpServerRequest req = routingContext.request();
                    HttpServerResponse resp = routingContext.response();

                    String absoluteURI = req.absoluteURI();
                    String uri = req.uri();
                    LOGGER.info("Receiving request, absoluteURI: {}, uri: {}", absoluteURI, uri);

                    resp.putHeader("content-type", "text/plain");
                    resp.end("Hello from RouterHttpServer.");

                    String name = req.getParam(person);
                    RequestOptions reqOpts = new RequestOptions();
                    reqOpts.setHost("localhost").setPort(9999).setURI("/api/greetings/" + name);
                    client.request(HttpMethod.POST, reqOpts).send(ar -> {
                        if (ar.succeeded()) {
                            String greetings = ar.result().bodyAsString(StandardCharsets.UTF_8.name());
                            LOGGER.info("Greetings: ", greetings);
                        }
                    });
                });

        Route interApiRoute = router.route();
        interApiRoute.method(HttpMethod.GET)
                .path("/inter-api/SayHelloToVertx/:" + person)
                .handler(routingContext -> {
                    HttpServerRequest req = routingContext.request();
                    HttpServerResponse resp = routingContext.response();

                    String absoluteURI = req.absoluteURI();
                    String uri = req.uri();
                    LOGGER.info("Receiving request, absoluteURI: {}, uri: {}", absoluteURI, uri);

                    resp.putHeader("content-type", "text/plain");
                    resp.end("Hello from RouterHttpServer.");

                    String name = req.getParam(person);
                    RequestOptions reqOpts = new RequestOptions();
                    reqOpts.setHost("localhost").setPort(9999).setURI("/inter-api/greetings/" + name);
                    client.request(HttpMethod.POST, reqOpts).send(ar -> {
                        if (ar.succeeded()) {
                            String greetings = ar.result().bodyAsString(StandardCharsets.UTF_8.name());
                            LOGGER.info("Greetings: ", greetings);
                        }
                    });
                });
        Route openApiRoute = router.route();
        openApiRoute.method(HttpMethod.GET)
                .path("/open-api/SayHelloToVertx/:" + person)
                .handler(routingContext -> {
                    HttpServerRequest req = routingContext.request();
                    HttpServerResponse resp = routingContext.response();

                    String absoluteURI = req.absoluteURI();
                    String uri = req.uri();
                    LOGGER.info("Receiving request, absoluteURI: {}, uri: {}", absoluteURI, uri);

                    resp.putHeader("content-type", "text/plain");
                    resp.end("Hello from RouterHttpServer.");

                    String name = req.getParam(person);
                    RequestOptions reqOpts = new RequestOptions();
                    reqOpts.setHost("localhost").setPort(9999).setURI("/open-api/greetings/" + name);
                    client.request(HttpMethod.POST, reqOpts).send(ar -> {
                        if (ar.succeeded()) {
                            String greetings = ar.result().bodyAsString(StandardCharsets.UTF_8.name());
                            LOGGER.info("Greetings: ", greetings);
                        }
                    });
                });

        server.requestHandler(router::accept).listen();
    }
}
