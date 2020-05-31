package com.example.mockServerDemo.controller;

import com.example.mockServerDemo.model.Greeting;
import com.example.mockServerDemo.model.MockParams;
import com.example.mockServerDemo.service.ExpectationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("/mock")
@Api(value = "创建mock数据")
public class MockController {

    @Autowired
    private ExpectationsService expectationsService;

    @ApiOperation(value = "创建mock接口",notes = "请求地址匹配方式进行mock数据创建")
    @PostMapping("/createExpectations")
    public String createExpectation(@RequestBody MockParams mockParams){
        expectationsService.requestMatchers(mockParams);
        return "result";
    }


}
