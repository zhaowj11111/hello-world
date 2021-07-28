package com.itcodai.course01;

import com.alibaba.fastjson.JSON;
import com.itcodai.common.RedisUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/25 14:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisUtilsTest {

    @Resource
    private RedisUtils redisUtils;

    @Test
    public void stringTest(){
        redisUtils.setString("weichat","程序员私房菜");
        log.info("我的微信公众号为：{}", redisUtils.getString("weichat"));

        User user = new User("CSDN", "123456");
        redisUtils.setString("userInfo", JSON.toJSONString(user));
        log.info("用户信息：{}", redisUtils.getString("userInfo"));
    }

    @Test
    public void hashTest(){
        User user = new User("zhao", "wenju");
        //测试redis的hash类型
        redisUtils.setHash("user", "name", JSON.toJSONString(user));
        log.info("用户姓名：{}", redisUtils.getHash("user","name"));
    }


    @Test
    public void listTest(){
        //测试redis的list类型
        redisUtils.setList("list", "football");
        redisUtils.setList("list", "basketball");
        List<String> valList = redisUtils.getList("list",0,-1);
        for(String value :valList){
            log.info("list中有：{}", value);
        }
    }

    @Data
    class User{
        String name;
        String password;
        User(String name, String password){
            this.name = name;
            this.password = password;
        }
    }
}
