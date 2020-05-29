package com.example.mockServerDemo.model;

import lombok.Data;

/**
 * mockserver reponse配置对应的实体类
 */
@Data
public class MockResponsetEntity {

    /**
     * 返回内容
     */
    private String body;
}
