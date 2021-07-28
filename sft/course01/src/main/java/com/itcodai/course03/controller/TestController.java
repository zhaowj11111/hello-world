package com.itcodai.course03.controller;

import com.itcodai.course03.config.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/14 16:04
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${url.orderUrl}")
    private String orderUrl;

    @Autowired
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======倪升武的个人博客：{}；倪升武的CSDN博客：{}", str1, str2);
        return "success";
    }

    @RequestMapping("/config")
    public String testConfig() {
        logger.info("=====获取的订单服务地址为：{}", orderUrl);
        return "success";
    }

    @RequestMapping("/moreConfig")
    public String testMoreConfig(){
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的购物服务地址为：{}", microServiceUrl.getShoppingUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        return "success";
    }
}
