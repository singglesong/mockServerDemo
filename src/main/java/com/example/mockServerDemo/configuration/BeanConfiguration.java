package com.example.mockServerDemo.configuration;

import com.example.mockServerDemo.common.ExpectationInitializerExample;
import org.mockserver.client.MockServerClient;
import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.server.initialize.ExpectationInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.security.auth.login.CredentialNotFoundException;

@Configuration
public class BeanConfiguration {

    @Value("${mockserver_ip}")
    private  String ip;
    @Value("${mockserver_port}")
    private  Integer port;
    @Autowired
    private MockserverConfiguration configuration;


    @Bean
    @Primary
    MockServerClient initMockServerClient(){
        return new MockServerClient(ip,port);
    }

    @Bean  // 启动mockserver 监听1080端口
    ClientAndServer startMockServer(){
        configuration.InitializationAndPersistenceConfig();
        return ClientAndServer.startClientAndServer(1080);
    }

    @Bean
    ExpectationInitializer expectationInitializer(){
        return new ExpectationInitializerExample();
    }
}
