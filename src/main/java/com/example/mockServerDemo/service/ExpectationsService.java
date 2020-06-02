package com.example.mockServerDemo.service;

import com.example.mockServerDemo.model.MockEntity;
import com.example.mockServerDemo.model.MockParams;
import com.example.mockServerDemo.utils.MockUtils;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.Expectation;
import org.mockserver.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


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


}
