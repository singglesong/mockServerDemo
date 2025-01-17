package com.example.mockServerDemo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * mockserver reponse配置对应的实体类
 */
@Data
public class MockResponsetEntity {


    /**
     * 原因说明
     */
    private String reasonPhrase;

    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 延迟时间
     */
    private Long time;

    /**
     * 时间的单位
     */
    private TimeUnit timeUnit;
    /**
     * 头信息，name和value都支持正则表达式，正则表达式支持反选-实现方式待解决 TODO
     */
    private HashMap<String,String> headers;

    /**
     * cookie
     */
    private HashMap<String,String>cookie;

    /**
     * body
     */
    private String body;

    /**
     * body 多种类型的判断   TODO
     */
    private String bodyType;
}
