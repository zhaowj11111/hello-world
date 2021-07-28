package com.itcodai.course01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/14 11:31
 */
@RestController
@RequestMapping("/start")
public class StartController {

    @RequestMapping("/springboot")
    public String startSpringBoot(){
        return "Welcome to the world of Spring Boot!";
    }

}
