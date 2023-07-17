package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 跨域问题配置类
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.访问路径
         * 2.请求来源-允许的域
         * 3.方法-允许的请求方式
         * 4.允许携带-是否发送Cookie信息
         * 5.最大时间
         */
        registry.addMapping("/**") //拦截所有的请求
                .allowedOrigins("Http://localhost:8080","null")
                .allowedMethods("GET","POST","OPTIONS","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
