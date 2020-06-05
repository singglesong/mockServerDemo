package com.example.mockServerDemo.common;

import org.mockserver.mock.Expectation;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.server.initialize.ExpectationInitializer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ExpectationInitializerExample implements ExpectationInitializer {


    @Override
    public Expectation[] initializeExpectations() {
        return new Expectation[]{
                //台州票务统计
                new Expectation(
                        request()
                                .withPath("/ticket/statis/moneyTrend")
                )
                        .thenRespond(
                        response()
                                .withBody("{\n" +
                                        "\t\"code\":8200,\n" +
                                        "\t\"data\":{\n" +
                                        "\t\t\"x\":[\n" +
                                        "\t\t\t\"6-25\",\n" +
                                        "\t\t\t\"6-26\",\n" +
                                        "\t\t\t\"6-27\",\n" +
                                        "\t\t\t\"6-28\",\n" +
                                        "\t\t\t\"6-29\",\n" +
                                        "\t\t\t\"6-30\",\n" +
                                        "\t\t\t\"6-31\",\n" +
                                        "\t\t\t\"7-1\",\n" +
                                        "\t\t\t\"7-2\",\n" +
                                        "\t\t\t\"7-3\"\n" +
                                        "\t\t],\n" +
                                        "\t\t\"y\":[\n" +
                                        "\t\t\t1667.0,\n" +
                                        "\t\t\t5061.0,\n" +
                                        "\t\t\t10987.0,\n" +
                                        "\t\t\t8041.0,\n" +
                                        "\t\t\t5981.0,\n" +
                                        "\t\t\t6973.0,\n" +
                                        "\t\t\t16217.0,\n" +
                                        "\t\t\t6159.0,\n" +
                                        "\t\t\t10059.0,\n" +
                                        "\t\t\t3590.0\n" +
                                        "\t\t]\n" +
                                        "\t},\n" +
                                        "\t\"message\":\"请求成功\",\n" +
                                        "\t\"success\":true\n" +
                                        "}")
                ),

                new Expectation(
                        request()
                                .withPath("/ticket/statis/userTrend")
                )
                        .thenRespond(
                        response()
                                .withBody("{\n" +
                                        "\t\"code\":8200,\n" +
                                        "\t\"data\":{\n" +
                                        "\t\t\"x\":[\n" +
                                        "\t\t\t\"5-25\",\n" +
                                        "\t\t\t\"5-26\",\n" +
                                        "\t\t\t\"5-27\",\n" +
                                        "\t\t\t\"5-28\",\n" +
                                        "\t\t\t\"5-29\",\n" +
                                        "\t\t\t\"5-30\",\n" +
                                        "\t\t\t\"5-31\",\n" +
                                        "\t\t\t\"6-1\",\n" +
                                        "\t\t\t\"6-2\",\n" +
                                        "\t\t\t\"6-3\"\n" +
                                        "\t\t],\n" +
                                        "\t\t\"y\":[\n" +
                                        "\t\t\t41,\n" +
                                        "\t\t\t121,\n" +
                                        "\t\t\t289,\n" +
                                        "\t\t\t193,\n" +
                                        "\t\t\t145,\n" +
                                        "\t\t\t161,\n" +
                                        "\t\t\t385,\n" +
                                        "\t\t\t138,\n" +
                                        "\t\t\t206,\n" +
                                        "\t\t\t103\n" +
                                        "\t\t]\n" +
                                        "\t},\n" +
                                        "\t\"message\":\"请求成功\",\n" +
                                        "\t\"success\":true\n" +
                                        "}")
                ),

                new Expectation(
                        request()
                                .withPath("/ticket/statis/channel")
                )
                        .thenRespond(
                        response()
                                .withBody("{\n" +
                                        "\t\"code\":8200,\n" +
                                        "\t\"data\":[\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":873,\n" +
                                        "\t\t\t\"type\":\"成人票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":137,\n" +
                                        "\t\t\t\"type\":\"老年票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":68,\n" +
                                        "\t\t\t\"type\":\"联票-成人票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":61,\n" +
                                        "\t\t\t\"type\":\"台州府城墙成人票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":35,\n" +
                                        "\t\t\t\"type\":\"台州府城墙-网络票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":33,\n" +
                                        "\t\t\t\"type\":\"联票-老年票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":31,\n" +
                                        "\t\t\t\"type\":\"儿童票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":27,\n" +
                                        "\t\t\t\"type\":\"东湖成人票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":22,\n" +
                                        "\t\t\t\"type\":\"学生票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":17,\n" +
                                        "\t\t\t\"type\":\"(台州府城墙+东湖)成人票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":11,\n" +
                                        "\t\t\t\"type\":\"联票-学生票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":11,\n" +
                                        "\t\t\t\"type\":\"台州府城墙成人票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":7,\n" +
                                        "\t\t\t\"type\":\"东湖老年票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":4,\n" +
                                        "\t\t\t\"type\":\"联票-儿童票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":3,\n" +
                                        "\t\t\t\"type\":\"台州府城墙儿童票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":3,\n" +
                                        "\t\t\t\"type\":\"东湖成人票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":2,\n" +
                                        "\t\t\t\"type\":\"（台州府城墙+东湖）儿童票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":2,\n" +
                                        "\t\t\t\"type\":\"台州府城墙老年票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":2,\n" +
                                        "\t\t\t\"type\":\"联票-团队成人票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":1,\n" +
                                        "\t\t\t\"type\":\"台州内学生团队\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":1,\n" +
                                        "\t\t\t\"type\":\"团队半价票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":1,\n" +
                                        "\t\t\t\"type\":\"东湖导服费100\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":1,\n" +
                                        "\t\t\t\"type\":\"联票-团队半价票\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":1,\n" +
                                        "\t\t\t\"type\":\"（台州府城墙+东湖）老年票-助销客\"\n" +
                                        "\t\t},\n" +
                                        "\t\t{\n" +
                                        "\t\t\t\"count\":1,\n" +
                                        "\t\t\t\"type\":\"团队成人票\"\n" +
                                        "\t\t}\n" +
                                        "\t],\n" +
                                        "\t\"message\":\"请求成功\",\n" +
                                        "\t\"success\":true\n" +
                                        "}")
                ),

                new Expectation(
                        request()
                                .withPath("/api/ticket")
                )
                        .thenRespond(
                        response()
                                .withBody("{\"code\":8200,\"data\":[{\"name\":\"\\u53f0\\u5dde\\u5e9c\\u57ce\\u5899\",\"value\":860},{\"name\":\"\\u4e1c\\u6e56\",\"value\":355},{\"name\":\"\\u53f0\\u5dde\\u5e9c\\u57ce\\u5899+\\u4e1c\\u6e56\",\"value\":139},{\"name\":\"\\u5bfc\\u6e38\\u670d\\u52a1\\u8d39\",\"value\":1}],\"message\":\"\\u8bf7\\u6c42\\u6210\\u529f\",\"success\":true}\n")
                )
        };
    }
}
