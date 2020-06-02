package com.example.mockServerDemo.utils;

import com.example.mockServerDemo.model.MockEntity;
import com.example.mockServerDemo.model.MockParams;
import com.example.mockServerDemo.model.MockRequestParams;
import com.example.mockServerDemo.model.MockResponseParams;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.Delay;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.NottableString;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

/**
 * 新建预期过程中封装的工具类
 */
public class MockUtils {


    /**
     *  将前端参数转换为可用的request对象
     * @param mockEntity
     * @param mockParams
     * @return
     */
    public static void setRequestFromParam(MockEntity mockEntity, MockParams mockParams){
        HttpRequest httpRequest = request();
        MockRequestParams requestParams = mockParams.getRequestParams();

        //path
        if(requestParams.getPath()!=null&&!requestParams.isInvertPath()){
            httpRequest.withPath(requestParams.getPath());
        }else if(requestParams.getPath()!=null&&requestParams.isInvertPath()){
            httpRequest.withPath(NottableString.not(requestParams.getPath()));
        }

        //method
        if(requestParams.getMethod()!=null&&!requestParams.isInvertMethod()){
            httpRequest.withMethod(requestParams.getMethod());
        }else if(requestParams.getMethod()!=null&&requestParams.isInvertMethod()){
            httpRequest.withMethod(NottableString.not(requestParams.getMethod()));
        }

        //params  TODO 不支持反选
        if(requestParams.getParams()!=null){
            for (Map.Entry<String,String> entry:requestParams.getParams().entrySet()){
                httpRequest.withQueryStringParameter(entry.getKey(),entry.getValue());
            }
        }

        //cookie  TODO 不支持反选
        if(requestParams.getCookie()!=null){
            for(Map.Entry<String,String> entry:requestParams.getCookie().entrySet()){
                httpRequest.withCookie(entry.getKey(),entry.getValue());
            }
        }

        //headers
        if(requestParams.getHeaders()!=null){
            for(Map.Entry<String,String> entry:requestParams.getHeaders().entrySet()){
                httpRequest.withHeader(entry.getKey(),entry.getValue());
            }
        }

        //body  TODO 不支持类型选择
        if(requestParams.getBody()!=null){
            httpRequest.withBody(requestParams.getBody());
        }

        mockEntity.setHttpRequest(httpRequest);
    }

    /**
     *  将前端参数转换为可用的request对象
     * @param mockEntity
     * @param mockParams
     * @return
     */
    public static void setResponseFromParam(MockEntity mockEntity, MockParams mockParams){
        HttpResponse response = response();
        MockResponseParams responseParams = mockParams.getResponseParams();

        //cookie  TODO 不支持反选
        if(responseParams.getCookie()!=null){
            for(Map.Entry<String,String> entry:responseParams.getCookie().entrySet()){
                response.withCookie(entry.getKey(),entry.getValue());
            }
        }

        //headers
        if(responseParams.getHeaders()!=null){
            for(Map.Entry<String,String> entry:responseParams.getHeaders().entrySet()){
                response.withHeader(entry.getKey(),entry.getValue());
            }
        }

        if(responseParams.getReasonPhrase()!=null){
            response.withReasonPhrase(responseParams.getReasonPhrase());
        }

        if(responseParams.getStatusCode()!=null){
            response.withStatusCode(responseParams.getStatusCode());
        }

        if(responseParams.getTime()!=null&&responseParams.getTimeUnit()!=null){
            response.withDelay(responseParams.getTimeUnit(),responseParams.getTime());
        }

        //body  TODO 不支持类型选择
        if(responseParams.getBody()!=null){
            response.withBody(responseParams.getBody());
        }

        mockEntity.setHttpResponse(response);
    }


    /**
     *  将前端参数转换为可用的mockEntity对象
     * @param mockEntity
     * @param mockParams
     */
    public static void setMockFromParam(MockEntity mockEntity, MockParams mockParams){
        //setTimes
        if(mockParams.getTimes()!=null){
           mockEntity.setTimes(Times.exactly(mockParams.getTimes()));
       }

       //setTimeToLive  单位默认second，时间默认60
       if(mockParams.getTime()!=null&&mockParams.getTimeUnit()!=null){
           mockEntity.setTimeToLive(TimeToLive.exactly(mockParams.getTimeUnit(),mockParams.getTime()));

       }

       //setPoriority
       if(mockParams.getPoriority()!=null){
           mockEntity.setPoriority(mockParams.getPoriority());
       }

       setRequestFromParam(mockEntity,mockParams);
       setResponseFromParam(mockEntity,mockParams);
    }


    public static void main(String[] args) {

    }

}
