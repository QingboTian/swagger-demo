package com.tqb.swagger.controller;

import com.tqb.swagger.pojo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/10/3 14:47
 * @Version v1.0
 */
@RestController
@Api(tags = "Demo的Controller层", value = "/Demo")
public class DemoController {

    @GetMapping("hello")
    @ApiOperation(value = "hello接口", notes = "田青菠 2019-10-5", httpMethod = "GET")
    public String hello(){
        return "hello";
    }


    @PostMapping("student")
    @ApiOperation(value = "添加学生", notes = "田青菠 2019-10-5", httpMethod = "POST")
    public Student student(@RequestBody Student student){
        return student;
    }
}
