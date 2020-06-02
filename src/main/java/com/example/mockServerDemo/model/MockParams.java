package com.example.mockServerDemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="创建mock接口的参数model",description="创建excetion所需要的所有参数" )
public class MockParams {
    /**
     * 次数
     */
    @ApiModelProperty(dataType="Integer",example = "1")
    private Integer times;

    /**
     * 优先权配置
     */
    @ApiModelProperty(dataType="Integer",allowableValues="-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10",example = "0")
    private Integer poriority;

    /**
     * 持续时间
     */
    @ApiModelProperty(dataType = "Long",example = "1")
    private Long time;

    /**
     * 持续时间的单位
     */
    @ApiModelProperty(dataType="java.util.concurrent.TimeUnit",example ="SECONDS" ,allowableValues = "MILLISECONDS, DAYS, MICROSECONDS, HOURS, NANOSECONDS, SECONDS, MINUTES")
    private TimeUnit timeUnit;


    private MockRequestParams requestParams;


    private MockResponseParams responseParams;
}
