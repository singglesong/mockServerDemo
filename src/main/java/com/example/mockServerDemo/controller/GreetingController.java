package com.example.mockServerDemo.controller;

import com.example.mockServerDemo.model.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "web 2.0 测试版本")
public class GreetingController {

    @ApiOperation(value = "跳转到上传数据页面",notes = "生成一个空对象来接受前端后续上传的数据，返回前端展示上传数据的页面")
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @ApiOperation(value = "上传数据",notes = "上传数据后告诉跳转到result页面，展示上传到数据")
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

}
