package com.example.mockServerDemo.model;

import lombok.Data;
import org.mockserver.matchers.TimeToLive;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 接受前端传参的实体类
 */
@Data
public class MockParams {
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
    private Long time;

    /**
     * 持续时间的单位
     */
    private TimeUnit timeUnit;

    /**
     * 匹配的路径，支持正则表达式，字符串路径形式。其中正则表达式支持反选
     */
    private String  path;

    /**
     *  当path 是正则时，判断是否使用反选
     */
    @Value("true")
    private boolean matchPath;

    /**
     * 请求方法，支持字符串和正则表达式，正则表达式支持反选
     */
    private String method;

    /**
     * 正则匹配时，方法是否反选
     */
    @Value("true")
    private boolean matchMethod;

    /**
     * url 参数，name和value都支持正则表达式
     */
    private HashMap<String,String> params;

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
