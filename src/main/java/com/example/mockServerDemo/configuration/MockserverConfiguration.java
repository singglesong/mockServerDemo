package com.example.mockServerDemo.configuration;

import com.example.mockServerDemo.common.ExpectationInitializerExample;
import org.mockserver.configuration.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class MockserverConfiguration {

    @Value("${mockserver_config_persistedExpectationsPath}")
    private String persistedExpectationsPath;
    @Value("${mockserver_config_initializationJsonPath}")
    private String initializationJsonPath;
    @Value("${mockserver_config_watchInitializationJson}")
    private boolean  enable;
    @Value("${mockserver_config_persistExpectations}")
    private boolean persistExpectations;

    public void InitializationAndPersistenceConfig() {


        ConfigurationProperties.persistExpectations( persistExpectations);
        ConfigurationProperties.persistedExpectationsPath( persistedExpectationsPath);
        ConfigurationProperties.initializationJsonPath( initializationJsonPath);
        ConfigurationProperties.watchInitializationJson( enable);
//        ConfigurationProperties.initializationClass( .class.getName());

    }

    public static void main(String[] args) {
        try{
            System.out.println(ResourceUtils.getURL("classpath:").getPath());
        }catch (Exception e){

        }
    }
}
