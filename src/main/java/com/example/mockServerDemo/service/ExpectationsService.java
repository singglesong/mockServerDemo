package com.example.mockServerDemo.service;

import com.example.mockServerDemo.model.MockEntity;
import com.example.mockServerDemo.model.MockParams;
import com.example.mockServerDemo.utils.MockUtils;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.Expectation;
import org.mockserver.model.Format;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;


/**
 * 新建预期值
 */
@Service
public class ExpectationsService {

    @Autowired
    private MockServerClient mockServerClient;

    @Autowired
    private ClientAndServer clientAndServer;

    @Value("${mockserver_ip}")
    private  String ip;
    @Value("${mockserver_port}")
    private  Integer port;

    /**
     * 组织发送server的body体
     * @param mockParams
     */
    public void createRequestMatchers(MockParams mockParams){
        MockEntity mockEntity =new MockEntity();
        MockUtils.setMockFromParam(mockEntity,mockParams);
        mockServerClient.when(
                mockEntity.getHttpRequest(),
                mockEntity.getTimes(),
                mockEntity.getTimeToLive(),
                mockEntity.getPoriority()
        ).respond(
                mockEntity.getHttpResponse()
        );
    }


    /**
     * 通过ID 更新 Expectation
     * @param mockParams
     */
    public void updateRequestMatchers(MockParams mockParams){
        MockEntity mockEntity =new MockEntity();
        MockUtils.setMockFromParam(mockEntity,mockParams);
        mockServerClient.upsert(
                new Expectation(
                        mockEntity.getHttpRequest()
                ).withId("some_unique_id").
                thenRespond(
                        mockEntity.getHttpResponse()
                ));
    }

    /**
     * 代理模式记录请求然后生成Expectation
     * @param path
     */
    public void recordedExpectations(String path){
        Expectation[] recordedExpectations = mockServerClient.retrieveRecordedExpectations(
                HttpRequest.request().withPath(path)
               );
        for (Expectation expectation:recordedExpectations){
//            expectation.getHttpRequest().getHeaders().remove("Cookie");
//            expectation.getHttpRequest().withCookie("userName","tzfc");
//            mockServerClient.when(expectation.getHttpRequest()).respond(expectation.getHttpResponse());
            mockServerClient.when(
                   HttpRequest.request().withPath(expectation.getHttpRequest().getPath())
            ).respond(
                    HttpResponse.response().withBody(expectation.getHttpResponse().getBody())
            );
            break;

        }
    }

}
