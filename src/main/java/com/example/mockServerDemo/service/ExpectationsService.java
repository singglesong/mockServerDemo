package com.example.mockServerDemo.service;

import com.example.mockServerDemo.model.MockEntity;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 新建预期值
 */
@Service
public class ExpectationsService {

    @Autowired
    private static MockServerClient mockServerClient;

    /**
     * 组织发送server的body体
     * @param mockEntity
     */
    public void requestMatchers(MockEntity mockEntity){
        mockServerClient.when(
                mockEntity.getHttpRequest()
        ).respond(
                mockEntity.getHttpResponse()
                );
    }

}
