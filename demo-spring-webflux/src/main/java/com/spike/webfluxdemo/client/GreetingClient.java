package com.spike.webfluxdemo.client;

import com.spike.webfluxdemo.hello.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * date: 2021/9/7
 * author: Spike
 * description:
 */
@Component
public class GreetingClient {

    private final WebClient webClient;

    public GreetingClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8888").build();
    }

    public Mono<String> getMessage(){
        return this.webClient.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting.class)
                .map(Greeting::getMessage);
    }
}
