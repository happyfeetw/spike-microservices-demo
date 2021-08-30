package com.spike.demoservicea.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@RestController
public class DemoaController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        User remoteUser = restTemplate.getForObject("http://localhost:9999/greetings/{name}",
                User.class,
                preparePathVariables("name", name));
        Assert.notNull(remoteUser,"remoteUser must not be null.");
        System.out.println("remoteUser = " + remoteUser);
        return "hello " + name +", "+remoteUser.getAge() + "years old.";
    }

    @RequestMapping("/api/sayHello/{name}")
    public String apiSayHello(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:9999/api/greetings/{name}",
                String.class,
                preparePathVariables("name", name));
    }

    @RequestMapping("/inter-api/sayHello/{name}")
    public String interApiSayHello(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:9999/inter-api/greetings/{name}",
                String.class,
                preparePathVariables("name",name));
    }

    @RequestMapping("/openapi/sayHello/{name}")
    public String openApiSayHello(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:9999/openapi/greetings/{name}",
                String.class,
                preparePathVariables("name",name));
    }

    private Map<String,String> preparePathVariables(String varKey, String varVal){
        HashMap<String, String> uriVars = new HashMap<>(2);
        uriVars.put(varKey,varVal);
        return uriVars;
    }
}
