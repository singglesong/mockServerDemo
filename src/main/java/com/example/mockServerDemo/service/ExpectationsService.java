package com.example.mockServerDemo.service;

import com.example.mockServerDemo.model.MockEntity;
import com.example.mockServerDemo.model.MockParams;
import com.example.mockServerDemo.utils.MockRequestUtils;
import org.mockserver.client.MockServerClient;
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
    private  MockServerClient mockServerClient;

    @Value("${mockserver_ip}")
    private  String ip;
    @Value("${mockserver_port}")
    private  Integer port;

    /**
     * 组织发送server的body体
     * @param mockParams
     */
    public void requestMatchers( MockParams mockParams){
        MockEntity mockEntity =new MockEntity();
        MockRequestUtils.setMockFromParam(mockEntity,mockParams);
        new MockServerClient(ip,port).when(
                mockEntity.getHttpRequest()
        ).respond(
                HttpResponse.response().withBody("hello test")
                );
    }



}
