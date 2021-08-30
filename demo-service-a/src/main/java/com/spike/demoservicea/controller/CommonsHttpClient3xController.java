package com.spike.demoservicea.controller;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * date: 2021/8/9
 * author: Spike
 * description:
 */
@RestController
public class CommonsHttpClient3xController {

    @Resource
    private HttpClient httpClient3x;

    @RequestMapping("/api/sayHello-httpclient-3x/{name}")
    public String sayHello(@PathVariable("name") String name) throws IOException {

        String url = "http://localhost:9999/api/greetings/"+name;
        GetMethod method = new GetMethod(url);
        URI uri = method.getURI();
        System.out.println("uri.getHost() = " + uri.getHost());
        System.out.println("uri.getURI() = " + uri.getURI());
        System.out.println("uri.getPort() = " + uri.getPort());
        System.out.println("uri.getPath() = " + uri.getPath());
        httpClient3x.executeMethod(method);

        return method.getResponseBodyAsString();
    }

}
