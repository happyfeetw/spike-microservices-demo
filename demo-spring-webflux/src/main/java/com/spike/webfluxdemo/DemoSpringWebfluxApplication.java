package com.spike.webfluxdemo;

import com.spike.webfluxdemo.client.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringWebfluxApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoSpringWebfluxApplication.class, args);
        GreetingClient client = ctx.getBean(GreetingClient.class);
        System.out.println(">> message = "+client.getMessage().block());
    }

}
