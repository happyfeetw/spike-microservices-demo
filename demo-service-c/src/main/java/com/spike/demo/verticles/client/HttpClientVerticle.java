package com.spike.demo.verticles.client;

import com.spike.demo.entity.User;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;


public class HttpClientVerticle extends AbstractVerticle {

    public static final Logger LOG = LoggerFactory.getLogger(HttpClientVerticle.class);


    @Override
    public void start() {
        Vertx vertx = Vertx.vertx();
        WebClient client = WebClient.create(vertx);
        HttpRequest<Buffer> req = client.request(HttpMethod.GET, 9999, "localhost", "/greetings/James");
        vertx.setPeriodic(3000L,handler -> req.send(ar -> {
            if (ar.succeeded()){
                User user = ar.result().bodyAsJson(User.class);
                LOG.warn("user: " + user.toString());
            }
        }));

        /*req.send(ar -> {
            User user = ar.result().bodyAsJson(User.class);
            LOG.warn("user: "+user.toString());
        });*/

        //"http://192.168.14.130:8764/projectA/test"
        /*HttpRequest<Buffer> req = client.request(HttpMethod.GET, 8764, "192.168.14.130", "/projectA/test");
        req.send(ar ->{
            if (ar.succeeded()) System.out.println(ar.result().statusMessage());
        });*/



        /*client.get(8764,"192.168.14.130","/projectA/test").send(ar ->{
            if (ar.succeeded()) System.out.println(ar.result().statusMessage());
        });*/

        /*HttpClient client = verticles.createHttpClient();
        HttpClientRequest request = client.request(HttpMethod.GET, 8764, "192.168.14.130", "/projectA/test", respHandler -> {

        });

        request.sendHead();*/


    }
}
