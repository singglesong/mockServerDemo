package com.example.mockServerDemo.model;

import lombok.Data;

import java.util.HashMap;

/**
 * mockserver request配置对应的实体类
 */

@Data
public class MockRequestEntity {
    /**
     * 匹配的路径，支持正则表达式，字符串路径形式。其中正则表达式支持反选
     */
    private String  path;

    /**
     *  当path 是正则时，判断是否使用反选
     */
    private boolean matchPath;

    /**
     * 请求方法，支持字符串和正则表达式，正则表达式支持反选
     */
    private String method;

    /**
     * 正则匹配时，方法是否反选
     */
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
