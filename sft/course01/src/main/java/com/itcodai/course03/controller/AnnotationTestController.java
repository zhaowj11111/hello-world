package com.itcodai.course03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/23 17:23
 */
@Slf4j
@RestController
@RequestMapping("/testAnnotation")
public class AnnotationTestController {

    @GetMapping("/user/{idd}")
    public String testPathVariable(@PathVariable("idd") String id){
        System.out.println("获取到的id为：" + id);
        return "success";
    }

}
