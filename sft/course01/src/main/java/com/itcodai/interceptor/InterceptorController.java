package com.itcodai.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/25 11:13
 */
@RestController
@RequestMapping("/interceptor")
@Slf4j
public class InterceptorController {

    @GetMapping("/test")
    public String testInterceptor(){
        log.info("进入了controller方法》》》");
        return "success";
    }
}
