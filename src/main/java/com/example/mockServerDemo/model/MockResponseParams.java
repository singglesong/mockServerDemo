package com.example.mockServerDemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Data
@ApiModel(value="创建mock接口的response参数model",description="创建excetion所需要的response所有参数" )
public class MockResponseParams {


    /**
     * 原因说明
     */
    private String reasonPhrase;

    /**
     * 状态码
     */
    @ApiModelProperty(dataType="Intege",example ="200" )
    private Integer statusCode;

    /**
     * 延迟时间
     */
    @ApiModelProperty(dataType = "Long",example = "1")
    private Long time;

    /**
     * 持续时间的单位
     */
    @ApiModelProperty(dataType="java.util.concurrent.TimeUnit",example ="SECONDS" ,allowableValues = "MILLISECONDS, DAYS, MICROSECONDS, HOURS, NANOSECONDS, SECONDS, MINUTES")
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
//    private String bodyType;
}
