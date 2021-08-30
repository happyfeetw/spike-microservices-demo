package com.spike.demoserviceb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class DemobController {

    @RequestMapping("/greetings/{name}")
    public User greetings(@PathVariable("name") String name){
        log.info("receive request...................");
        return new User(name,18);
    }

    @RequestMapping("/api/greetings/{name}")
    public String apiGreetings(@PathVariable("name") String name){
        log.info("receive API request");
        return "api - greetings to "+name;
    }

    @RequestMapping("/inter-api/greetings/{name}")
    public String interApiGreetings(@PathVariable("name") String name){
        log.info("receive INTER-API request");
        return "inter-api - greetings to "+name;
    }

    @RequestMapping("/openapi/greetings/{name}")
    public String openApiGreetings(@PathVariable("name") String name){
        log.info("receive OPENAPI request");
        return "openapi - greetings to "+name;
    }

    @RequestMapping("/not-in-api/greetings/{name}")
    public String notInApiGreetings(@PathVariable("name") String name){
        log.info("receive NOT-IN-API request");
        return "not-in-api - greetings to " + name;
    }
}
