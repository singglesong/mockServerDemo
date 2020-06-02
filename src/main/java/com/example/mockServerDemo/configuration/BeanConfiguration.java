package com.example.mockServerDemo.configuration;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {

    @Value("${mockserver_ip}")
    private  String ip;
    @Value("${mockserver_port}")
    private  Integer port;


    @Bean
    @Primary
    MockServerClient initMockServerClient(){
        return new MockServerClient(ip,port);
    }

    @Bean
    ClientAndServer startMockServer(){
         return ClientAndServer.startClientAndServer(1080);
    }
}
