package com.spike.demoservicea.config;

import org.apache.commons.httpclient.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * date: 2021/8/9
 * author: Spike
 * description:
 */
@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpClient httpClient(){
        return new HttpClient();
    }
}
