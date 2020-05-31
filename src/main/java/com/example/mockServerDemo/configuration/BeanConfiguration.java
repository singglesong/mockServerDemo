package com.example.mockServerDemo.configuration;

import org.mockserver.client.MockServerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Value("${mockserver_ip}")
    private  String ip;
    @Value("${mockserver_port}")
    private  Integer port;
    @Bean
    MockServerClient mockServerClient(){
        return new MockServerClient(ip,port);
    }
}
