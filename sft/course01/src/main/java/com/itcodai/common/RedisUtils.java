package com.itcodai.common;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/25 14:50
 */
@Component
public class RedisUtils {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public void setString(String key, String value){
        ValueOperations<String, String> stringOperations = stringRedisTemplate.opsForValue();
        stringOperations.set(key, value);
    }

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setHash(String key, String filedKey, String value){
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put(key,filedKey,value);
    }

    public String getHash(String key, String filedKey){
        return (String)stringRedisTemplate.opsForHash().get(key, filedKey);
    }

    /**
     * set redis:list类型
     * @param key key
     * @param value value
     * @return
     */
    public long setList(String key, String value){
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    /**
     * get redis:list类型
     * @param key key
     * @param start start
     * @param end end
     * @return
     */
    public List<String> getList(String key, long start, long end){
        return stringRedisTemplate.opsForList().range(key, start, end);
    }
}
