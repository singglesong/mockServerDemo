package com.example.mockServerDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问地址  http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.mockServerDemo.controller";
    public static final String VERSION = "1.0.0";
    @Bean
    public Docket createRestApi() {
        //主要api配置机制初始化为swagger规范2.0
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("mockserver 测试 RESTful API")
                // 描述信息
                .description("mockserver 测试 RESTful API 接口列表")
                //服务网址
                .termsOfServiceUrl("https://www.baidu.com")
                // 联系方式
                .contact(new Contact("yghyt","暂无","暂无"))
                //版本号
                .version(VERSION)
                .build();
    }
}
