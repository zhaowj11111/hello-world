package com.itcodai.config;

import com.itcodai.common.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/25 11:09
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * addPathPatterns("/**") 方法是添加要拦截的请求，这里我们拦截所有的请求。
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
