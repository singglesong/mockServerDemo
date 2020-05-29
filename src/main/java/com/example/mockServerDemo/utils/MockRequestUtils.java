package com.example.mockServerDemo.utils;

import com.example.mockServerDemo.model.MockEntity;
import com.example.mockServerDemo.model.MockParams;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.NottableString;

import java.util.Map;

/**
 * 新建请求预期过程中封装的工具类
 */
public class MockRequestUtils {


//
//    public static void getMock(MockServerClient mockServerClient, MockEntity entity){
//        Times times;
//        TimeToLive timeToLive;
//
//        if(entity.getTimes()!=null){
//            times = entity.getTimes();
//        }
//
//        if(entity.getTimes()!=null){
//            timeToLive = entity.getTimeToLive();
//        }
//
//        mockServerClient.when(entity.getHttpRequest());
//    }

    /**
     *  将前端参数转换为可用的request对象
     * @param mockEntity
     * @param mockParams
     * @return
     */
    public static void getRequest(MockEntity mockEntity, MockParams mockParams){
        HttpRequest httpRequest = mockEntity.getHttpRequest();

        //path
        if(mockParams.getPath()!=null&&mockParams.isMatchPath()){
            httpRequest.withPath(mockParams.getPath());
        }else if(mockParams.getPath()!=null&&!mockParams.isMatchPath()){
            httpRequest.withPath(NottableString.not(mockParams.getPath()));
        }

        //method
        if(mockParams.getMethod()!=null&&mockParams.isMatchMethod()){
            httpRequest.withMethod(mockParams.getMethod());
        }else if(mockParams.getMethod()!=null&&!mockParams.isMatchMethod()){
            httpRequest.withMethod(NottableString.not(mockParams.getMethod()));
        }

        //params  TODO 不支持反选
        if(mockParams.getParams()!=null){
            for (Map.Entry<String,String> entry:mockParams.getParams().entrySet()){
                httpRequest.withQueryStringParameter(entry.getKey(),entry.getValue());
            }
        }

        //cookie  TODO 不支持反选
        if(mockParams.getCookie()!=null){
            for(Map.Entry<String,String> entry:mockParams.getCookie().entrySet()){
                httpRequest.withCookie(entry.getKey(),entry.getValue());
            }
        }

        //headers
        if(mockParams.getHeaders()!=null){
            for(Map.Entry<String,String> entry:mockParams.getHeaders().entrySet()){
                httpRequest.withHeader(entry.getKey(),entry.getValue());
            }
        }

        //body
        if(mockParams.getBody()!=null){

        }
    }


}
