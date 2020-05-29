package com.example.mockServerDemo.model;

import lombok.Data;
import org.joda.time.field.AbstractPartialFieldProperty;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * mock 配置对应的实体类
 */
@Data
public class MockEntity {

    /**
     * 次数
     */
    private Times times;

    /**
     * 优先权配置
     */
    private Integer poriority;

    /**
     * 持续时间
     */
    private TimeToLive timeToLive;

    /**
     * 请求
     */
    private HttpRequest httpRequest;

    /**
     * 响应
     */
    private HttpResponse httpResponse;


}
